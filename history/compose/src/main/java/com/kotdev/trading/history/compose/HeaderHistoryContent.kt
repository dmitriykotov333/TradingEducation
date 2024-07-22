package com.kotdev.trading.history.compose

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.core_ui.Poppins

@Composable
fun HeaderHistoryContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(onClick = {
            AppNavigator.back(AppGraph.App)
        }) {
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(com.kotdev.trading.core_ui.R.drawable.back_arrow), contentDescription = null
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            text = stringResource(com.kotdev.trading.core_ui.R.string.back),
            style = TextStyle(
                color = Color(0xFF838383),
                lineHeight = 25.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
    }

}