package com.kotdev.trading.core_ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val Poppins = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.poppins_light, FontWeight.Light
        ),
        Font(
            resId = R.font.poppins_black, FontWeight.Black
        ),
        Font(
            resId = R.font.poppins_bold, FontWeight.Bold
        ),
        Font(
            resId = R.font.poppins_semi_bold, FontWeight.SemiBold
        ),
        Font(
            resId = R.font.poppins_regular, FontWeight.Normal
        ),
    )
)