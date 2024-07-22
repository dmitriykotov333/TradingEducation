package com.kotdev.trading.history.presentation

import androidx.compose.runtime.Immutable


@Immutable
data class HistoryViewState(
    val profit: Float = 0f,
    val profitFormat: String = ""
)