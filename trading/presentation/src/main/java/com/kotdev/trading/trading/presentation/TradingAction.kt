package com.kotdev.trading.trading.presentation

import HistoryItem

sealed class TradingAction {
    data class UpdateLocale(val language: String) : TradingAction()
    data object ContactDialog : TradingAction()
    data object InfoPopUp: TradingAction()
    data class FinishPopUp(val data: HistoryItem): TradingAction()
    data object History: TradingAction()
    data class BalanceInfo(val msg: Int): TradingAction()
}