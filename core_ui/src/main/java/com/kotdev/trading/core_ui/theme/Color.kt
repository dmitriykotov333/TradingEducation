package com.kotdev.trading.core_ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val PairColor = Color(0xFF6C6C6C)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val Background = Color(0xFF323234)
val Grey = Color(0xFF9D9D9D)
val Green = Color(0xFF40A71C)

data class AppColors(
    val neutralWhite: Color,
    val neutralBlack: Color,
    val grey: Color,
    val red: Color,
    val pairColor: Color,
    val greenDark: Color,
    val green: Color,
    val greenText: Color,
    val gradientChart: Brush
)

val palette = AppColors(
    neutralWhite = Color(0xFFFAFAFA),
    neutralBlack = Color(0xFF323234),
    grey = Color(0xFF2F2F2F),
    red = Color(0xFFC34444),
    greenDark = Color(0xFF295751),
    green = Color(0xFF40A71C),
    greenText = Color(0xFF23D0B2),
    pairColor = Color(0xFF6C6C6C),
    gradientChart = Brush.verticalGradient(
        listOf(Color(0xFF295751), Color(0x4D295751), Color(0xFF323234))
    )
)

val LocalColorProvider = staticCompositionLocalOf<AppColors> { error("No default implementation") }