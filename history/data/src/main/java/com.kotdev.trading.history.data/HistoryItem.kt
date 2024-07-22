package com.kotdev.trading.history.data

import androidx.compose.runtime.Immutable


@Immutable
data class HistoryItem(
    val createdAt: Long,
    val created: String,
    val icon: Int,
    val pair: String,
    val openTime: String,
    val closeTime: String,
    val openPrice: Double,
    val closePrice: Double,
    val profit: Double
)