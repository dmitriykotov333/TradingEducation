package com.kotdev.trading.trading.model

import com.kotdev.trading.trading.model.entities.TradingType

interface SessionManager : SessionAction, SessionDatabase, SessionEvent, SessionTrading {
    fun tradingStart(pair: String, type: TradingType)

    fun tradingStop(pair: String, closePrice: Float)

    fun selectedPair(pair: String)
}