package com.kotdev.trading.trading.data.extensions

import com.kotdev.trading.trading.model.entities.TradingData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.random.Random


internal fun List<TradingData>.addTradings(
    currentPrice: Float
): List<TradingData> {
    val tradingData = mutableListOf<TradingData>()
    tradingData.addAll(this)
    tradingData.add(
        TradingData(
            time = System.currentTimeMillis(),
            price = currentPrice
        )
    )
    return tradingData
}

internal fun updateLineData(data: List<TradingData>): LineData {
    val entries = data.mapIndexed { index, value ->
        Entry(index.toFloat(), value.price)
    }.takeLast(40)
    val newDataSet = LineDataSet(entries, "").apply {
        axisDependency = com.github.mikephil.charting.components.YAxis.AxisDependency.RIGHT
        color = android.graphics.Color.WHITE
        lineWidth = 2f
        setDrawCircles(false)
        setDrawValues(false)
        setDrawCircleHole(false)
        setDrawFilled(false)
        isHighlightEnabled = false
        mode = LineDataSet.Mode.CUBIC_BEZIER
    }
    return LineData(newDataSet)
}

internal fun generateProgress(): Pair<Int, Int> {
    val down = Random.nextInt(0, 101)
    val up = 100 - down
    return Pair(down, up)
}

internal inline fun calculateProgress(
    time: Int,
    progress: (Int, Pair<Int, Int>) -> Unit,
) {
    if (time >= 10) {
        val down = Random.nextInt(0, 101)
        val up = 100 - down
        progress(0, Pair(down, up))
    }
}