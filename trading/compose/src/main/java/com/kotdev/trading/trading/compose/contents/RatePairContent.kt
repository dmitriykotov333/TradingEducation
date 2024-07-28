package com.kotdev.trading.trading.compose.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kotdev.trading.core.extensions.formatFloat
import com.kotdev.trading.core.extensions.formatFloatPercent
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.presentation.TradingViewState


@Composable
fun RatePairContent(
    state: TradingViewState,
) {
    val controller = LocalNavigator.currentOrThrow

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        AsyncImage(
            modifier = Modifier.size(37.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(state.pair.icon)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = state.pair.pair,
            style = TextStyle(
                color = Theme.colors.pairColor,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Percent(state)
        IconButton(modifier = Modifier.size(50.dp), onClick = {
            controller.push(ScreenRegistry.get(AppGraph.Settings))
        }) {
            Image(
                modifier = Modifier
                    .width(38.dp)
                    .height(40.dp),
                painter = painterResource(R.drawable.education),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun RowScope.Percent(
    state: TradingViewState,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            modifier = Modifier,
            text = state.pair.currentPrice.formatFloat(),
            style = TextStyle(
                color = Theme.colors.neutralWhite,
                lineHeight = 24.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            modifier = Modifier.graphicsLayer {
                rotationZ = if (state.pair.percent >= 0) 0f else 180f
            },
            painter = painterResource(R.drawable.top_rate),
            contentDescription = null,
            colorFilter = ColorFilter.tint(if (state.pair.percent >= 0) Theme.colors.green else Theme.colors.red)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier,
            text = state.pair.percent.formatFloatPercent(),
            style = TextStyle(
                color = if (state.pair.percent >= 0) Theme.colors.green else Theme.colors.red,
                lineHeight = 24.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Spacer(modifier = Modifier.width(20.dp))
    }
}