package com.kotdev.trading.core

data class BasePair(
    val pair: String,
    val value: Double,
    val timeNextUpdate: String
)