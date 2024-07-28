package com.kotdev.trading.trading.data


import com.kotdev.trading.trading.model.entities.TradingPair
import com.kotdev.trading.trading.model.entities.TradingType
import com.kotdev.trading.BalanceDBO
import com.kotdev.trading.BalanceDao
import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.HistoryDao
import com.kotdev.trading.core.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

class TradingManager(
    private val balanceDao: BalanceDao,
    private val historyDao: HistoryDao
) {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val tradingJobs = mutableMapOf<String, Job>()

    private val map = ConcurrentHashMap<String, TradingPair>()

    private fun calculateUp(pair: String, currentPrice: Float, startingPrice: Float): Float {
        return (currentPrice - startingPrice) * pair.profitabilityRatio() * 1000
    }

    private fun calculateDown(pair: String, currentPrice: Float, startingPrice: Float): Float {
        return (startingPrice - currentPrice) * pair.profitabilityRatio() * 1000
    }

    private fun TradingType.calculateProfit(
        pair: String, currentPrice: Float, startingPrice: Float
    ): Float {
        return when (this) {
            TradingType.DOWN -> {
                calculateDown(pair, currentPrice, startingPrice)
            }

            TradingType.UP -> {
                calculateUp(pair, currentPrice, startingPrice)
            }
        }
    }

    private fun String.profitabilityRatio(): Float {
        return when (this) {
            Utils.USD_EUR -> 0.87f
            Utils.USD_JPY -> 0.85f
            Utils.USD_CHF -> 0.90f
            Utils.USD_CAD -> 0.90f
            Utils.USD_NZD -> 0.90f
            else -> 0.87f
        }
    }

    fun getTrading(pair: String): TradingPair? {
        return if (tradingJobs.containsKey(pair)) {
            map[pair]
        } else {
            null
        }
    }

    fun getActiveTrading(pair: String, closePrice: Float): TradingPair? {
        return if (tradingJobs.containsKey(pair)) {
            println("getActiveTrading $pair with close price $closePrice")
            updateTradingPair(pair, closePrice)
        } else {
            null
        }
    }

    private fun updateTradingPair(pair: String, closePrice: Float): TradingPair? {
        return map[pair]?.let { trading ->
            println("Trading update $pair with close price $closePrice")
            val rst = trading.copy(
                closePrice = closePrice,
                profit = trading.type.calculateProfit(
                    pair = pair,
                    startingPrice = trading.openPrice,
                    currentPrice = closePrice
                )
            )
            map.replace(pair, rst)
            return rst
        }
    }

    fun startTrading(pair: TradingPair): TradingPair? {
        if (tradingJobs.containsKey(pair.pair)) {
            println("Trading for ${pair.pair} is already running.")
            return null
        }
        val job = coroutineScope.launch {
            map.put(pair.pair, pair)
        }
        tradingJobs[pair.pair] = job
        return pair
    }

    suspend fun stopTrading(pair: String, closePrice: Float): TradingPair? {
        tradingJobs[pair]?.cancel()
        tradingJobs.remove(pair)
        val remove = map.remove(pair)
        val rst = remove?.let {
            val id = historyDao.insert(
                HistoryDBO(
                    createdAt = it.createdAt,
                    icon = it.pair.getIcon(),
                    pair = it.pair,
                    openTime = it.tradeOpenTime,
                    closeTime = System.currentTimeMillis(),
                    openPrice = it.openPrice.toDouble(),
                    closePrice = closePrice.toDouble(),
                    profit = it.profit.toDouble()
                )
            )
            historyDao.getById(id)
        }
        val cacheBalance = balanceDao.getOnlyBalance() ?: 5000.0

        balanceDao.clean()
        balanceDao.insert(
            BalanceDBO(
                balance = cacheBalance + (remove?.profit ?: 0f).toDouble()
            )
        )
        println("Stopped trading on pair: ${pair} - ${cacheBalance + (remove?.profit ?: 0f).toDouble()}")
        return rst?.mapToTradingPair(remove.type)
    }

    fun stopAllTrading() {
        tradingJobs.values.forEach { it.cancel() }
        tradingJobs.clear()
        println("Stopped all trading")
    }
}