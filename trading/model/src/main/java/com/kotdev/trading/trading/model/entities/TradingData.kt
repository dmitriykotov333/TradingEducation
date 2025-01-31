package com.kotdev.trading.trading.model.entities

import androidx.compose.runtime.Immutable

@Immutable
data class TradingData(
    val time: Long,
    val price: Float,
)