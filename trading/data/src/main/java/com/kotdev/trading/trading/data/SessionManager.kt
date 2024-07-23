package com.kotdev.trading.trading.data

import BasePair
import BaseSessionPair
import EventTrading
import PairItem
import TradingData
import TradingPair
import TradingType
import androidx.compose.runtime.Immutable
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.kotdev.trading.BalanceDao
import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.HistoryDao
import com.kotdev.trading.PairDBO
import com.kotdev.trading.PairDao
import com.kotdev.trading.core.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random


@Singleton
class SessionManager @Inject constructor(
    private val balanceDao: BalanceDao,
    private val pairDao: PairDao,
    private val historyDao: HistoryDao
) {


    private var pairJob: Job? = null

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val tradingScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val tradingManager = TradingManager(tradingScope, balanceDao, historyDao)

    private val map = ConcurrentHash<String, BaseSessionPair>()

    private var activePair = Utils.USD_EUR
    private var activeTrading = mutableListOf<String>()

    private val eventManager: MutableSharedFlow<EventTrading> =
        MutableSharedFlow(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val pairAction: MutableSharedFlow<BasePair> =
        MutableSharedFlow(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val tradingPair: MutableSharedFlow<TradingPair?> =
        MutableSharedFlow(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val pairDatabase: MutableSharedFlow<List<PairItem>> =
        MutableSharedFlow(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    fun eventTrading() = eventManager.asSharedFlow()

    fun tradingPair() = tradingPair.asSharedFlow()

    fun activePair() = pairAction.asSharedFlow()

    fun collectPair() = pairDatabase.asSharedFlow()

    private fun initData(items: List<PairDBO>) {
        if (pairJob != null) return
        pairJob = coroutineScope.launch {
            items.forEach {
                val generate = MutableList(40) { i ->
                    TradingData(
                        time = System.currentTimeMillis(),
                        price = it.value.toFloat() + Random.nextDouble(-0.00075, 0.00075)
                            .toFloat()
                    )
                }
                map.put(
                    it.pair, BaseSessionPair(
                        icon = it.pair.getIcon(),
                        pair = it.pair,
                        apiPrice = it.value.toFloat(),
                        currentPrice = it.value.toFloat(),
                        percent = 0f,
                        lineData = updateLineData(generate),
                        tradingData = generate
                    )
                )
            }
            map.getMap().forEach { s, baseSessionPair ->
                launch {
                    startPriceUpdates(baseSessionPair)
                }
            }

            pairDatabase.emit(items.map { pair ->
                pair.mapToPairUI()
            })
        }
    }

    private suspend fun initPairFromDatabase() {
        pairDao.flowAll().cancellable().collectLatest {
            initData(it)
        }
    }

    fun tradingStart(pair: String, type: TradingType) {
        coroutineScope.launch {
            if (activeTrading.find { it == pair } == null) {
                activeTrading.add(pair)
                val start = tradingManager.startTrading(
                    map.get(pair)!!.mapToTrading(type)
                )
                tradingPair.emit(start)
            }
        }
    }

    fun tradingStop(pair: String, closePrice: Float) {
        coroutineScope.launch {
            activeTrading.remove(pair)
            val stop = tradingManager.stopTrading(pair = pair, closePrice = closePrice)
            tradingPair.emit(null)
            stop?.let {
                eventManager.emit(EventTrading.PopUp(stop.mapToUIFinish()))
            }
        }
    }

    fun selectedPair(pair: String) {
        coroutineScope.launch {
            activePair = pair
            pairAction.emit(map.get(activePair)!!.mapToBasePair())
            tradingPair.emit(tradingManager.getTrading(activePair))
        }
    }


    init {
        coroutineScope.launch {
            initPairFromDatabase()
        }
    }


    private fun generateProgress(): Pair<Int, Int> {
        val down = Random.nextInt(0, 101)
        val up = 100 - down
        return Pair(down, up)
    }

    private suspend fun startPriceUpdates(pair: BaseSessionPair) {
        var progressPair: Pair<Int, Int>? = generateProgress()
        var progressTime = 0
        while (true) {
            val apiPrice = pair.apiPrice

            val currentPrice =
                apiPrice + Random.nextDouble(-0.00075, 0.00075).toFloat()
            val tradingData = mutableListOf<TradingData>()
            tradingData.addAll(map.get(pair.pair)!!.tradingData)
            tradingData.add(
                TradingData(
                    time = System.currentTimeMillis(),
                    price = currentPrice
                )
            )
            val lineData = updateLineData(tradingData)
            if (progressTime >= 10) {
                val down = Random.nextInt(0, 101)
                val up = 100 - down
                progressPair = Pair(down, up)
                progressTime = 0
            }
            map.change(
                pair.pair, map.get(pair.pair)!!.copy(
                    currentPrice = currentPrice,
                    lineData = lineData,
                    percent = ((currentPrice - apiPrice) / apiPrice) * 100,
                    tradingData = tradingData,
                    progress = progressPair
                )
            )
            pairAction.emit(map.get(activePair)!!.mapToBasePair())
            activeTrading.forEach {
                coroutineScope.launch {
                    if (pair.pair == it) {
                        tradingManager.getActiveTrading(it, currentPrice)
                    }
                }
            }
            tradingPair.emit(tradingManager.getTrading(activePair))
            progressTime += 1
            delay(3000)
        }
    }

    private fun updateLineData(data: List<TradingData>): LineData {
        val entries = data.mapIndexed { index, value ->
            Entry(index.toFloat(), value.price)
        }.takeLast(40)
        val newDataSet = LineDataSet(entries, "").apply {
            axisDependency = com.github.mikephil.charting.components.YAxis.AxisDependency.RIGHT
            color = android.graphics.Color.WHITE
            lineWidth = 2f
            setDrawCircles(false)
            setDrawValues(false)
            setDrawCircleHole(false)
            setDrawFilled(false)
            isHighlightEnabled = false
            mode = LineDataSet.Mode.CUBIC_BEZIER
        }
        return LineData(newDataSet)
    }


}