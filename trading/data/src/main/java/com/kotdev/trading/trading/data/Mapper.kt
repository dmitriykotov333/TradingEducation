package com.kotdev.trading.trading.data

import com.kotdev.trading.trading.model.entities.BasePair
import com.kotdev.trading.trading.model.entities.BaseSessionPair
import HistoryItem
import com.kotdev.trading.trading.model.entities.PairItem
import com.kotdev.trading.trading.model.entities.TradingPair
import com.kotdev.trading.trading.model.entities.TradingType
import com.kotdev.trading.HistoryDBO
import com.kotdev.trading.PairDBO
import com.kotdev.trading.core.Utils.USD_CAD
import com.kotdev.trading.core.Utils.USD_CHF
import com.kotdev.trading.core.Utils.USD_EUR
import com.kotdev.trading.core.Utils.USD_JPY
import com.kotdev.trading.core.Utils.USD_NZD
import com.kotdev.trading.core.extensions.dateToFormat
import com.kotdev.trading.core.extensions.dateToFormatDialog
import com.kotdev.trading.core.extensions.longToDateFormat
import com.kotdev.trading.core_ui.R
import java.util.Calendar
import java.util.Date

fun BasePair.mapToTrading(type: TradingType): TradingPair {
    val time = System.currentTimeMillis()
    return TradingPair(
        pair = this.pair,
        createdAt = time,
        tradeOpenTime = time,
        tradeCloseTime = null,
        openPrice = this.currentPrice,
        closePrice = this.currentPrice,
        profit = 0f,
        type = type
    )
}

fun BaseSessionPair.mapToTrading(type: TradingType): TradingPair {
    val time = System.currentTimeMillis()
    return TradingPair(
        pair = this.pair,
        createdAt = time,
        tradeOpenTime = time,
        tradeCloseTime = null,
        openPrice = this.currentPrice,
        closePrice = this.currentPrice,
        profit = 0f,
        type = type
    )
}

fun BaseSessionPair.mapToBasePair(): BasePair {
    return BasePair(
        icon = this.icon,
        pair = this.pair,
        currentPrice = this.currentPrice,
        percent = this.percent,
        lineData = this.lineData,
        progress = progress
    )

}

fun HistoryDBO.mapToTradingPair(type: TradingType): TradingPair {
    return TradingPair(
        pair = this.pair,
        createdAt = this.createdAt,
        tradeOpenTime = this.openTime,
        tradeCloseTime = this.closeTime,
        openPrice = this.openPrice.toFloat(),
        closePrice = this.closePrice.toFloat(),
        profit = this.profit.toFloat(),
        type = type
    )
}

fun TradingPair.mapToUIFinish(): HistoryItem {
    val open = Date(this.tradeOpenTime)
    val close = Date(this.tradeCloseTime!!)
    val diff = (close.time - open.time) / 1000
    val hours = diff / 3600
    val minutes = (diff - (3600 * hours)) / 60
    val seconds = (diff - (3600 * hours)) - minutes * 60
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, hours.toInt())
    calendar.set(Calendar.MINUTE, minutes.toInt())
    calendar.set(Calendar.SECOND, seconds.toInt())
    return HistoryItem(
        createdAt = this.createdAt,
        created = this.createdAt.longToDateFormat(),
        icon = this.pair.getIcon(),
        pair = this.pair,
        openTime = open.dateToFormat(),
        closeTime = calendar.time.dateToFormatDialog(),
        openPrice = this.openPrice.toDouble(),
        closePrice = this.closePrice.toDouble(),
        profit = this.profit.toDouble(),
    )
}

fun PairDBO.mapToPairUI(): PairItem {
    return PairItem(
        icon = when (pair) {
            USD_EUR -> R.drawable.usd_eur
            USD_JPY -> R.drawable.usd_py
            USD_CHF -> R.drawable.usd_chf
            USD_CAD -> R.drawable.usd_cad
            USD_NZD -> R.drawable.usd_nzd
            else -> R.drawable.usd_eur
        },
        name = pair,
        value = value.toFloat()
    )
}