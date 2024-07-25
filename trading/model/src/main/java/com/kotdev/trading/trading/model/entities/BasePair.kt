package com.kotdev.trading.trading.model.entities

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.LineData

@Immutable
data class BaseSessionPair(
    val icon: Int,
    val pair: String,
    val apiPrice: Float,
    val currentPrice: Float,
    val percent: Float,
    val lineData: LineData,
    val tradingData: List<TradingData> = emptyList(),
    val progress: Pair<Int, Int>? = Pair(70, 30)
)

@Immutable
data class BasePair(
    val icon: Int,
    val pair: String,
    val currentPrice: Float,
    val percent: Float,
    val lineData: LineData,
    val coordinate: Coordinate = Coordinate(-1f, -1f, -1f),
    val progress: Pair<Int, Int>? = Pair(70, 30)
)

@Immutable
data class Coordinate(
    val x: Float,
    val y: Float,
    val value: Float
)