package com.kotdev.trading.history.data

import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.HistoryDao
import com.kotdev.trading.TradingDatabase
import com.kotdev.trading.core.di.Inject
import kotlinx.coroutines.flow.Flow


class HistoryRepository(
    private val database: TradingDatabase,
) {

    private val historyDao = database.historyDao

    suspend fun getProfit() = historyDao.getProfit()

    fun getAllPagingSource(): Flow<List<HistoryDBO>> = historyDao.observeAll()
}