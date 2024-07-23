package com.kotdev.trading.trading.compose.dialog

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.theme.Grey
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay

@Composable
fun InfoPopUp(
    onDismissRequest: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(10000)
        onDismissRequest()
    }
    Popup(
        offset = IntOffset(0, -210.dp.value.toInt()),
        alignment = Alignment.BottomCenter,
        properties = PopupProperties(
            excludeFromSystemGesture = true,
        ),
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .background(Theme.colors.neutralBlack, RoundedCornerShape(10.dp))
                .border(1.dp, Theme.colors.pairColor, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            IconButton(modifier = Modifier.align(Alignment.TopEnd), onClick = {
                onDismissRequest()
            }) {
                Image(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(R.drawable.close), contentDescription = null
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .padding(start = 15.dp, top = 25.dp, end = 35.dp, bottom = 20.dp),
                text = stringResource(R.string.info),
                style = TextStyle(
                    color = Grey,
                    lineHeight = 18.sp,
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light
                ),
            )
        }
    }
}