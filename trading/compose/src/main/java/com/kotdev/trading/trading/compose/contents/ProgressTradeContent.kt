package com.kotdev.trading.trading.compose.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.presentation.TradingEvent
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun ProgressTradeContent(
    progress: Pair<Int, Int> = Pair(70, 30),
    eventHandler: (TradingEvent) -> Unit
) {

    val value by rememberUpdatedState(progress)

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            modifier = Modifier,
            text = stringResource(R.string.down_with, value.first),
            style = TextStyle(
                color = Theme.colors.red,
                lineHeight = 14.sp,
                fontSize = 9.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Spacer(modifier = Modifier.width(7.dp))
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(22.dp)
                .clip(RoundedCornerShape(10.dp)),
            trackColor = Theme.colors.green,
            color = Theme.colors.red,
            strokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap, progress = {
                progress.first.toFloat() / 100
            })
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            modifier = Modifier,
            text = stringResource(R.string.up_with, value.second),
            style = TextStyle(
                color = Theme.colors.green,
                lineHeight = 14.sp,
                fontSize = 9.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Spacer(modifier = Modifier.width(2.dp))
        IconButton(onClick = {
            eventHandler.invoke(TradingEvent.InfoClick)
        }) {
            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(R.drawable.info),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}