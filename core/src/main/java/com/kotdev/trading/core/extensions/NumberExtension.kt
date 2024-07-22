package com.kotdev.trading.core.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import kotlin.math.abs

fun Float.formatNumber(): String {
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = ','
        decimalSeparator = '.'
    }

    return if (this % 1.0 == 0.0) {
        String.format("%02.0f", this)
        DecimalFormat("#,##0", symbols).format(this)
    } else {
        String.format("%06.3f", this)
        DecimalFormat("#,##0.00", symbols).format(this)
    }
}


fun Float.formatFloat(): String {
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = ','
        decimalSeparator = '.'
    }

    return if (this % 1.0 == 0.0) {
        DecimalFormat("#,##0.0000", symbols).format(this)
    } else {
        DecimalFormat("#,##0.0000", symbols).format(this)
    }
}

fun Float.chartFormatFloat(): String {
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = ','
        decimalSeparator = '.'
    }
    val rst = abs(this)
    return when {
        rst >= 1_000_000 -> {
            val formattedValue = this / 1_000_000
            DecimalFormat("#.0M", symbols).format(formattedValue)
        }
        rst >= 1_000 -> {
            val formattedValue = this / 1_000
            DecimalFormat("#.0k", symbols).format(formattedValue)
        }
        rst >= 100 -> {
            DecimalFormat("#,##0.00", symbols).format(this)
        }
        else -> {
            DecimalFormat("#,##0.0000", symbols).format(this)
        }
    }
}

fun Float.formatFloatPercent(): String {
    val decimalFormat = DecimalFormat("0.000")
    return decimalFormat.format(abs(this)).replace(",", ".") + "%"
}