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
import com.kotdev.trading.history.presentation.HistoryViewModel


@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel(),
) {
    val paging by viewModel.historyPagingSource.collectAsState()

    val states by viewModel.states().collectAsState()

    val positive by remember {
        derivedStateOf {
            states.profit > 0
        }
    }
    val isEmpty by remember {
        derivedStateOf {
            states.profitFormat.isEmpty()
        }
    }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderContent {
                AppNavigator.back(AppGraph.App)
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(
                    top = 15.dp, bottom = 90.dp, start = 15.dp, end = 15.dp
                ), verticalArrangement = Arrangement.spacedBy(
                    15.dp
                )
            ) {
                items(
                    items = paging,
                    key = {
                        it.createdAt
                    },
                    itemContent = {
                        History(it)
                    }
                )
            }
        }
        if (!isEmpty) {
            Row(
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            if (positive) listOf(
                                Color(0xFF375E2B), Color(0xFF40A71C)
                            ) else listOf(
                                Color(0xFF592A3A), Theme.colors.red
                            )
                        )
                    )
                    .navigationBarsPadding()
                    .padding(vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(com.kotdev.trading.core_ui.R.string.total_profit),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Color(0xFF222222),
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold
                    ),
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    modifier = Modifier
                        .background(
                            Color(0xFF222222),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 5.dp, horizontal = 25.dp),
                    text = states.profitFormat,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = if (positive) Theme.colors.green else Theme.colors.red,
                        lineHeight = 40.sp,
                        fontSize = 26.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
        }
    }
}


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
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
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
                Spacer(modifier = Modifier.height(17.dp))
                Text(
                    modifier = Modifier,
                    text = stringResource(com.kotdev.trading.core_ui.R.string.trade_open_time),
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
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF191F1F), Color(0xFF143530)
                                )
                            ),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 15.dp, vertical = 6.dp),
                    text = item.openTime,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(11.dp))
                Text(
                    modifier = Modifier,
                    text = stringResource(com.kotdev.trading.core_ui.R.string.trade_open_price),
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
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF191F1F), Color(0xFF143530)
                                )
                            ),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 15.dp, vertical = 6.dp),
                    text = item.openPrice.toFloat().chartFormatFloat(),
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
            Spacer(modifier = Modifier.width(15.dp))
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
                Text(
                    modifier = Modifier,
                    text = stringResource(com.kotdev.trading.core_ui.R.string.trade_close_time),
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
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF2C4B48), Color(0xFF199B87)
                                )
                            ),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 15.dp, vertical = 6.dp),
                    text = item.closeTime,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(11.dp))
                Text(
                    modifier = Modifier,
                    text = stringResource(com.kotdev.trading.core_ui.R.string.trade_close_price),
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
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF2C4B48), Color(0xFF199B87)
                                )
                            ),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 15.dp, vertical = 6.dp),
                    text = item.closePrice.toFloat().chartFormatFloat(),
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
        }
        Spacer(modifier = Modifier.height(17.dp))
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
}







