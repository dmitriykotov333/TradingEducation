package com.kotdev.trading.trading.model.entities

import HistoryItem
import androidx.compose.runtime.Immutable

@Immutable
sealed class EventTrading {
    data class PopUp(val tradingPair: HistoryItem) : EventTrading()
}