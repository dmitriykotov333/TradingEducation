package com.kotdev.trading.trading.presentation

import BasePair
import PairItem
import TradingPair
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList


@Immutable
data class TradingViewState(
    val locale: String = "English",
    val balance: Float,
    val pairs: ImmutableList<PairItem>,
    val pair: BasePair,
    val tradingPair: TradingPair? = null
)