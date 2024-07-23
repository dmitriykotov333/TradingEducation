package com.kotdev.trading.trading.presentation

import TradingType


sealed class TradingEvent {
    data class SelectedLocale(val language: String, val locale: String) : TradingEvent()
    data class SelectedPair(val pair: String) : TradingEvent()
    data class TradingStart(val pair: String, val type: TradingType) : TradingEvent()
    data class TradingStop(val pair: String, val closePrice: Float) : TradingEvent()
    data object ContactClick : TradingEvent()
    data object RefreshBalanceClick : TradingEvent()
    data object InfoClick : TradingEvent()
    data object HistoryClick : TradingEvent()
    data object CloseAppClick : TradingEvent()
}