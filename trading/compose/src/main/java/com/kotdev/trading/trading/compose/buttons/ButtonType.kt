package com.kotdev.trading.trading.compose.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme


interface ButtonType {
    val background: Brush
    val radius: Dp
    val text: Int
    val icon: Int
}

@Composable
fun RowScope.ButtonType(
    type: TradeBtnType,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .bounceClick(from = .9f)
            .fillMaxWidth()
            .weight(1f)
            .background(type.background, RoundedCornerShape(type.radius))
            .padding(vertical = 17.dp)
            .noRippleClickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(type.text),
            style = TextStyle(
                color = Theme.colors.neutralWhite,
                lineHeight = 27.sp,
                fontSize = 18.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Black
            ),
        )
        Spacer(modifier = Modifier.width(7.dp))
        Image(
            modifier = Modifier
                .size(14.dp)
                .graphicsLayer {
                    when (type) {
                        TradeBtnType.UP -> {

                        }

                        TradeBtnType.DOWN -> {
                            rotationX = 180f
                        }
                    }
                },
            painter = painterResource(type.icon),
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = null
        )
    }
}