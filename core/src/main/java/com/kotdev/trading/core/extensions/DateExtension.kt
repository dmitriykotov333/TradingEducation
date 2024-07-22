package com.kotdev.trading.core.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.dateToFormat(): String {
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    return dateFormat.format(this.time)
 }

fun Date.dateToFormatDialog(): String {
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return dateFormat.format(this.time)
}

fun Long.longToDateFormat(): String {
    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val date = Date(this)
    return dateFormat.format(date)
}