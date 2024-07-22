package com.kotdev.trading.history.data

import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.core.extensions.dateToFormat
import com.kotdev.trading.core.extensions.longToDateFormat
import com.kotdev.trading.history.data.HistoryItem
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

@ViewModelScoped
class HistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {

    suspend fun getProfit() = repository.getProfit()

    fun call(): Flow<List<HistoryDBO>> = repository.getAllPagingSource()
}

fun HistoryDBO.mapToUI(): HistoryItem {
    return HistoryItem(
        createdAt = this.createdAt,
        created = this.createdAt.longToDateFormat(),
        icon = this.icon,
        pair = this.pair,
        openTime = Date(this.openTime).dateToFormat(),
        closeTime = Date(this.closeTime).dateToFormat(),
        openPrice = this.openPrice,
        closePrice = this.closePrice,
        profit = this.profit,
    )
}