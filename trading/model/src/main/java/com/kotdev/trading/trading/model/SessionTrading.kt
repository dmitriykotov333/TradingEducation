package com.kotdev.trading.trading.model

import com.kotdev.trading.trading.model.entities.TradingPair
import kotlinx.coroutines.flow.SharedFlow

interface SessionTrading {
    fun tradingPair(): SharedFlow<TradingPair?>
}