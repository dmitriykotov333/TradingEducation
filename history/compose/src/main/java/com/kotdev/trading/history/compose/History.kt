package com.kotdev.trading.history.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kotdev.trading.core.extensions.chartFormatFloat
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.core_ui.component.HeaderContent
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import HistoryItem
import android.inputmethodservice.Keyboard.Row
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import com.kotdev.trading.history.presentation.HistoryViewModel

@Composable
internal fun History(
    item: HistoryItem
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF121212), Color(0xFF121212), Color(0xFF2C2C2C)
                    )
                ), RoundedCornerShape(10.dp)
            )
            .border(BorderStroke(1.dp, Theme.colors.neutralBlack), RoundedCornerShape(10.dp))
            .padding(horizontal = 45.dp, vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            LeftArea(item)
            Spacer(modifier = Modifier.width(15.dp))
            RightArea(item)
        }
        Spacer(modifier = Modifier.height(17.dp))
        Profit(item)
    }
}

@Composable
internal fun RowScope.RightArea(
    item: HistoryItem
) {
    Column(
        Modifier
            .fillMaxWidth()
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = item.created,
            style = TextStyle(
                color = Theme.colors.pairColor,
                lineHeight = 24.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
        Spacer(modifier = Modifier.height(17.dp))
        DataArea(
            title = com.kotdev.trading.core_ui.R.string.trade_close_time,
            value = item.closeTime,
            brush = Brush.verticalGradient(
                listOf(
                    Color(0xFF2C4B48), Color(0xFF199B87)
                )
            )
        )
        Spacer(modifier = Modifier.height(11.dp))
        DataArea(
            title = com.kotdev.trading.core_ui.R.string.trade_close_price,
            value = item.closePrice.toFloat().chartFormatFloat(),
            brush = Brush.verticalGradient(
                listOf(
                    Color(0xFF2C4B48), Color(0xFF199B87)
                )
            )
        )
    }
}

@Composable
internal fun RowScope.LeftArea(
    item: HistoryItem
) {
    Column(
        Modifier
            .fillMaxWidth()
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Pair(item)
        Spacer(modifier = Modifier.height(17.dp))
        DataArea(
            title = com.kotdev.trading.core_ui.R.string.trade_open_time,
            value = item.openTime
        )
        Spacer(modifier = Modifier.height(11.dp))
        DataArea(
            title = com.kotdev.trading.core_ui.R.string.trade_open_price,
            value = item.openPrice.toFloat().chartFormatFloat()
        )
    }
}

@Composable
internal fun Pair(
    item: HistoryItem
) {
    Row(
        Modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .width(34.dp)
                .height(21.dp),
            model = item.icon,
            contentDescription = item.icon.toString(),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            modifier = Modifier,
            text = item.pair,
            style = TextStyle(
                color = Theme.colors.neutralWhite,
                lineHeight = 24.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
    }
}

@Composable
internal fun DataArea(
    @StringRes title: Int,
    value: String,
    brush: Brush = Brush.verticalGradient(
        listOf(
            Color(0xFF191F1F), Color(0xFF143530)
        )
    )
) {
    Text(
        modifier = Modifier,
        text = stringResource(title),
        style = TextStyle(
            color = Theme.colors.pairColor,
            lineHeight = 24.sp,
            fontSize = 9.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Light
        ),
    )
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = brush,
                RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 15.dp, vertical = 6.dp),
        text = value,
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = Theme.colors.neutralWhite,
            lineHeight = 24.sp,
            fontSize = 16.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Light
        ),
    )
}

@Composable
internal fun Profit(
    item: HistoryItem
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    if (item.profit >= 0) listOf(
                        Color(0xFF1B2418), Color(0xFF304926)
                    ) else listOf(Color(0xFF271C1C), Color(0xFF503030))
                ),
                RoundedCornerShape(10.dp)
            )
            .padding(vertical = 7.dp),
        text = "${
            if (item.profit >= 0) "+${
                item.profit.toFloat().chartFormatFloat()
            }" else item.profit.toFloat().chartFormatFloat()
        }\$",
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = if (item.profit >= 0) Theme.colors.green else Theme.colors.red,
            lineHeight = 39.sp,
            fontSize = 26.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold
        ),
    )
}
