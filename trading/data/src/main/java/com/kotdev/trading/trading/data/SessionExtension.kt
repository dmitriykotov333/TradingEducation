package com.kotdev.trading.trading.data

import androidx.compose.runtime.Immutable
import com.github.mikephil.charting.data.LineData
import com.kotdev.trading.core.Utils

fun String.getIcon() : Int {
    return when(this) {
        Utils.USD_EUR -> com.kotdev.trading.core_ui.R.drawable.usd_eur
        Utils.USD_JPY -> com.kotdev.trading.core_ui.R.drawable.usd_py
        Utils.USD_CHF -> com.kotdev.trading.core_ui.R.drawable.usd_chf
        Utils.USD_CAD -> com.kotdev.trading.core_ui.R.drawable.usd_cad
        Utils.USD_NZD -> com.kotdev.trading.core_ui.R.drawable.usd_nzd
        else -> com.kotdev.trading.core_ui.R.drawable.usd_eur
    }
}