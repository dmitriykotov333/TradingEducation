package com.kotdev.trading.history.data

import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.HistoryDao
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class HistoryRepository @Inject constructor(
    private val historyDao: HistoryDao,
) {

    suspend fun getProfit() = historyDao.getProfit()

    fun getAllPagingSource(): Flow<List<HistoryDBO>> = historyDao.observeAll()
}