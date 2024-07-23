package com.kotdev.trading.trading.compose.buttons

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kotdev.trading.trading.compose.buttons.ButtonType
import com.kotdev.trading.core_ui.R

enum class TradeBtnType(
    override val background: Brush,
    override val radius: Dp,
    override val text: Int,
    override val icon: Int
) : ButtonType {

    UP(
        background = Brush.linearGradient(
            listOf(Color(0xFF19410B), Color(0xFF40A71C))
        ),
        radius = 10.dp,
        text = R.string.up,
        icon = R.drawable.top_rate
    ),
    DOWN(
        background = Brush.linearGradient(
            listOf(Color(0xFFC34444), Color(0xFF5D2020))
        ),
        radius = 10.dp,
        text = R.string.down,
        icon = R.drawable.top_rate
    )

}
