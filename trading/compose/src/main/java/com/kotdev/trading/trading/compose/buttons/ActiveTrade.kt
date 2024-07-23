package com.kotdev.trading.trading.compose.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core.extensions.chartFormatFloat
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.presentation.TradingViewState

@Composable
fun ActiveTrade(
    state: TradingViewState,
    onStop: () -> Unit
) {

    val profit by rememberUpdatedState(state.tradingPair?.profit ?: 0f)
    val positive by remember {
        derivedStateOf {
            profit >= 0f
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .drawBehind {
                drawRoundRect(
                    color = if (positive) Color(0xFF40A71C) else
                        Color(0xFFC34444),
                    size = size,
                    cornerRadius = CornerRadius(
                        x = 10.dp.toPx(),
                        y = 10.dp.toPx()
                    ),
                )
            }
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            modifier = Modifier
                .size(16.dp)
                .graphicsLayer {
                    if (positive) {
                        rotationX = 0f
                    } else {
                        rotationX = 180f
                    }
                },
            painter = painterResource(R.drawable.top_rate),
            colorFilter = ColorFilter.tint(Theme.colors.neutralBlack),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            text = "${if (positive) "+${profit.chartFormatFloat()}" else profit.chartFormatFloat()}\$",
            style = TextStyle(
                color = Theme.colors.neutralBlack,
                lineHeight = 41.sp,
                fontSize = 27.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Text(
            modifier = Modifier
                .bounceClick(from = .99f)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF0F6052), Color(0xFF158470)
                        )
                    ),
                    RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 35.dp, vertical = 7.dp)
                .noRippleClickable {
                    onStop()
                },
            text = stringResource(R.string.stop),
            style = TextStyle(
                color = Theme.colors.neutralWhite,
                lineHeight = 26.sp,
                fontSize = 17.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Spacer(modifier = Modifier.width(15.dp))

    }
}