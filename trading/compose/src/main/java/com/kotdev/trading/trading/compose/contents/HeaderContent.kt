package com.kotdev.trading.trading.compose.contents

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.kotdev.trading.core.extensions.formatNumber
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.presentation.TradingEvent
import com.kotdev.trading.trading.presentation.TradingViewState
import com.kotdev.trading.trading.compose.menu.DropDownMenu

@Composable
fun HeaderContent(
    state: TradingViewState,
    eventHandler: (TradingEvent) -> Unit
) {
    var menu by remember {
        mutableStateOf(false)
    }
    DropDownMenu(
        locale = state.locale,
        expanded = menu,
        eventHandler = eventHandler,
        onDismissRequest = {
            menu = false
        }
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(onClick = {
            menu = true
        }) {
            Image(
                modifier = Modifier
                    .width(20.dp)
                    .height(17.dp),
                painter = painterResource(R.drawable.menu), contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Theme.colors.neutralBlack, RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                eventHandler.invoke(TradingEvent.RefreshBalanceClick)
            }) {
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.refresh),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = "$${state.balance.formatNumber()}",
                style = TextStyle(
                    color = Theme.colors.greenText,
                    lineHeight = 27.sp,
                    letterSpacing = 4.sp,
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light
                ),
            )
            AsyncImage(
                modifier = Modifier.size(24.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.profile)
                    .crossfade(true)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                modifier = Modifier,
                text = stringResource(R.string.novice),
                style = TextStyle(
                    color = Theme.colors.greenText,
                    lineHeight = 13.sp,
                    fontSize = 9.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light
                ),
            )
            Spacer(modifier = Modifier.width(15.dp))
        }
        Spacer(modifier = Modifier.width(15.dp))
    }

}