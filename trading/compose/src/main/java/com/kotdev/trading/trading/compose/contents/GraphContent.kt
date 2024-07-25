package com.kotdev.trading.trading.compose.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginEnd
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.kotdev.trading.core.extensions.chartFormatFloat
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.model.entities.Coordinate
import com.kotdev.trading.trading.presentation.TradingViewModel
import com.kotdev.trading.trading.presentation.TradingViewState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun ColumnScope.GraphContent(
    state: TradingViewState,
    lineChart: (LineChart) -> Unit
) {

    val lineData by rememberUpdatedState(state.pair.lineData)
    var sizeDp by remember {
        mutableStateOf(Size(0f, 0f))
    }

    Box(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxSize()
            .weight(1f)
            .background(
                Theme.colors.neutralBlack, RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.TopStart
    ) {
        AndroidView(
            modifier = Modifier
                .padding(bottom = 25.dp, end = 50.dp)
                .fillMaxSize()
                .background(
                    Theme.colors.gradientChart, RoundedCornerShape(topStart = 10.dp)
                )
                .graphicsLayer {
                    sizeDp = size
                },
            factory = { context ->
                LineChart(context).apply {
                    setupChart()
                    lineChart(this)
                }
            },
            update = { view ->

                if (lineData.entryCount > 0) {
                    view.data = lineData
                    adjustXAxis(view)

                    view.axisRight.apply {
                        granularity = .001f
                        axisMinimum = getMinEntryCountSet(view).yMin - view.calcValue()
                        axisMaximum = view.data.maxEntryCountSet.yMax + view.calcValue()
                        removeAllLimitLines()
                        if (state.tradingPair?.openPrice != null) {
                            val ll = LimitLine(state.tradingPair!!.openPrice)
                            ll.lineColor = Color.Red.toArgb()
                            ll.lineWidth = 1f
                            addLimitLine(ll)
                        }
                    }

                }
            }
        )
        CustomMarkerContent(state.pair.coordinate, sizeDp)
    }

}

private fun LineChart.calcValue(): Float {
    return if (getMinEntryCountSet(this).yMin < 1) {
        0.01f
    } else {
        this.data.maxEntryCountSet.yMax
    }
}

private fun getMinEntryCountSet(chart: LineChart): ILineDataSet {
    var min = chart.data.dataSets.get(0)
    chart.data.dataSets.forEach {
        if (it.getEntryCount() > min.getEntryCount())
            min = it
    }
    return min
}

private fun LineChart.setupChart() {
    setTouchEnabled(false)
    isDragEnabled = false
    setScaleEnabled(false)
    setPinchZoom(false)
    setHighlightPerDragEnabled(false)
    setViewPortOffsets(0f, 0f, 0f, 0f)
    description.isEnabled = false
    legend.isEnabled = false
    axisRight.apply {

        setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        isEnabled = true
        setDrawAxisLine(false)
        setDrawGridLines(true)
        setLabelCount(7, false)
        setDrawAxisLine(true)
        gridLineWidth = 1.dp.value
        gridColor = Color(0xFF686869).toArgb()
        setTypeface(ResourcesCompat.getFont(context, R.font.poppins_light));
        setTextSize(10.dp.value);
        setTextColor(Color(0xFF686869).toArgb())
    }

    axisLeft.isEnabled = false

    xAxis.apply {
        position = XAxis.XAxisPosition.BOTTOM
        setDrawAxisLine(false)
        setDrawGridLines(true)
        setAvoidFirstLastClipping(true)
        setLabelCount(7, false)
        gridLineWidth = 1.dp.value
        gridColor = Color(0xFF686869).toArgb()
        setTypeface(ResourcesCompat.getFont(context, R.font.poppins_light));
        setTextSize(10.dp.value);
        setTextColor(Color(0xFF686869).toArgb())
        valueFormatter = DayAxisValueFormatter()
        spaceMin = 1f
        spaceMax = 2f
    }
}

private fun adjustXAxis(chart: LineChart) {
    val xAxis = chart.xAxis
    chart.setVisibleXRangeMaximum(20f)
    chart.moveViewToX(chart.data.entryCount.toFloat() + 300f)
}


private class DayAxisValueFormatter : ValueFormatter() {

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return SimpleDateFormat(
            "HH:mm",
            Locale.getDefault()
        ).format(Date(System.currentTimeMillis() + (value.toLong())))
    }

}

@Composable
private fun BoxScope.CustomMarkerContent(coordinate: Coordinate, sizeDp: Size) {
    Box(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .offset {
                IntOffset(0, coordinate.y.toInt())
            }
            .drawWithCache {
                this.onDrawBehind {
                    if (coordinate.y != -1f) {
                        drawLine(
                            color = Color(0xFF00E5E5),
                            start = Offset(
                                coordinate.x - sizeDp.width + 10.dp.toPx(),
                                sizeDp.height - coordinate.y
                            ),
                            end = Offset(coordinate.x - sizeDp.width + 10.dp.toPx(), 10.dp.toPx()),
                            strokeWidth = 1.dp.toPx()
                        )
                        val coordX = coordinate.x - sizeDp.width + 7.dp.toPx()

                        drawLine(
                            color = Color(0xFF00E5E5),
                            start = Offset(
                                if (coordX < 0) {
                                    coordX
                                } else {
                                    0f
                                }, 7.dp.toPx()
                            ),
                            end = Offset(10.dp.toPx(), 7.dp.toPx()),
                            strokeWidth = 1.3.dp.toPx()
                        )


                        val path = Path().apply {
                            moveTo(size.width * 0.2f, 0f)
                            lineTo(0f, size.height / 2)
                            lineTo(size.width * 0.2f, size.height)
                            lineTo(size.width, size.height)
                            lineTo(size.width, 0f)
                            close()
                        }
                        drawPath(
                            path = path,
                            color = Color(0xFF23D0B2),
                            style = Fill
                        )

                        val pathCircle = Path().apply {
                            val size = 12.dp.toPx()
                            addOval(Rect(0f, 0f, size, size))
                            op(
                                path1 = this,
                                path2 = Path().apply {
                                    addOval(
                                        Rect(0f, 0f, size * (1 - 1f), size * (1 - 1f))
                                    )
                                    translate(Offset(size * 1f / 2, size * 1f / 2))
                                },
                                operation = PathOperation.Difference
                            )
                            translate(Offset(coordinate.x - sizeDp.width + 4.dp.toPx(), 5f))
                        }
                        drawPath(pathCircle, Color.White)
                    }
                }
            }
            .padding(top = 1.dp, bottom = 1.dp, start = 17.dp, end = 3.dp)

    ) {
        Text(
            modifier = Modifier.padding(end = 12.dp),
            textAlign = TextAlign.Start,
            text = coordinate.value.chartFormatFloat(),
            color = Color(0xFF323234),
            fontSize = 10.sp
        )
    }
}