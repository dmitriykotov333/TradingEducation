package com.kotdev.trading.trading.compose.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotdev.trading.trading.presentation.TradingEvent
import com.kotdev.trading.trading.model.entities.TradingType

@Composable
fun ButtonsTrade(
    pair: String,
    eventHandler: (TradingEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(15.dp))
        ButtonType(
            type = TradeBtnType.UP,
            onClick = {
                eventHandler.invoke(TradingEvent.TradingStart(pair, TradingType.UP))
            }
        )
        Spacer(modifier = Modifier.width(15.dp))
        ButtonType(
            type = TradeBtnType.DOWN,
            onClick = {
                eventHandler.invoke(TradingEvent.TradingStart(pair, TradingType.DOWN))
            }
        )
        Spacer(modifier = Modifier.width(15.dp))
    }
}