package com.kotdev.trading.history.data

import HistoryItem
import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.HistoryDao
import com.kotdev.trading.core.di.Inject
import com.kotdev.trading.core.extensions.dateToFormat
import com.kotdev.trading.core.extensions.longToDateFormat
import kotlinx.coroutines.flow.Flow
import java.util.Date


class HistoryUseCase {

    private val repository = Inject.instance<HistoryRepository>()

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