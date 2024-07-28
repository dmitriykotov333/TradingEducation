package com.kotdev.trading.trading.data

import android.content.Context
import com.kotdev.trading.trading.model.SessionManager
import com.kotdev.trading.trading.model.entities.BasePair
import com.kotdev.trading.trading.model.entities.BaseSessionPair
import com.kotdev.trading.trading.model.entities.EventTrading
import com.kotdev.trading.trading.model.entities.PairItem
import com.kotdev.trading.trading.model.entities.TradingData
import com.kotdev.trading.trading.model.entities.TradingPair
import com.kotdev.trading.trading.model.entities.TradingType
import com.kotdev.trading.BalanceDao
import com.kotdev.trading.HistoryDao
import com.kotdev.trading.PairDBO
import com.kotdev.trading.PairDao
import com.kotdev.trading.core.Utils
import com.kotdev.trading.trading.data.extensions.addTradings
import com.kotdev.trading.trading.data.extensions.calculateProgress
import com.kotdev.trading.trading.data.extensions.generateProgress
import com.kotdev.trading.trading.data.extensions.updateLineData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

import kotlin.random.Random


@Singleton
class SessionManagerImpl @Inject constructor(
    private val context: Context,
    private val balanceDao: BalanceDao,
    private val pairDao: PairDao,
    private val historyDao: HistoryDao
) : SessionManager {

    private var pairJob: Job? = null

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val tradingManager = TradingManager(balanceDao, historyDao)

    private val map = ConcurrentHashMap<String, BaseSessionPair>()

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

    override fun eventTrading() = eventManager.asSharedFlow()

    override fun tradingPair() = tradingPair.asSharedFlow()

    override fun activePair() = pairAction.asSharedFlow()

    override fun collectPair() = pairDatabase.asSharedFlow()

    init {
        coroutineScope.launch {
            initPairFromDatabase()
        }
    }

    private suspend fun initPairFromDatabase() {
        pairDao.flowAll().cancellable().collectLatest {
            initData(it)
        }
    }

    private fun initData(items: List<PairDBO>) {
        if (pairJob != null) return
        pairJob = coroutineScope.launch {
            pairDatabase.emit(items.map { pair ->
                pair.mapToPairUI()
            })
            val deferred = items.map {
                async {
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
            }
            deferred.awaitAll()
            map.values.forEach {
                launch {
                    startPriceUpdates(it)
                }
            }
        }
    }

    private suspend fun startPriceUpdates(pair: BaseSessionPair) {
        var progressPair = generateProgress()
        var progressTime = 0
        while (true) {
            val apiPrice = pair.apiPrice

            val currentPrice =
                apiPrice + Random.nextDouble(-0.00075, 0.00075).toFloat()

            val tradingData = map[pair.pair]!!.tradingData.addTradings(currentPrice).takeLast(40)

            val lineData = updateLineData(tradingData)

            calculateProgress(
                time = progressTime,
                progress = { time, pair ->
                    progressPair = pair
                    progressTime = time
                }
            )

            map.replace(
                pair.pair, pair.copy(
                    currentPrice = currentPrice,
                    lineData = lineData,
                    percent = ((currentPrice - apiPrice) / apiPrice) * 100,
                    tradingData = tradingData,
                    progress = progressPair
                )
            )

            pairAction.emit(map[activePair]!!.mapToBasePair())

            activeTrading.find { pair.pair == it }?.let {
                val rst = tradingManager.getActiveTrading(it, currentPrice)
                if (rst?.pair == activePair) {
                    tradingPair.emit(rst)
                }
            }
            progressTime += 1
            delay(3000L)
        }
    }

    override fun tradingStart(pair: String, type: TradingType) {
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

    override fun tradingStop(pair: String, closePrice: Float) {
        coroutineScope.launch {
            activeTrading.remove(pair)
            val stop = tradingManager.stopTrading(pair = pair, closePrice = closePrice)
            tradingPair.emit(null)
            stop?.let {
                eventManager.emit(EventTrading.PopUp(stop.mapToUIFinish()))
            }
        }
    }

    override fun selectedPair(pair: String) {
        coroutineScope.launch {
            activePair = pair
            pairAction.emit(map.get(activePair)!!.mapToBasePair())
            tradingPair.emit(tradingManager.getTrading(activePair))
        }
    }

}