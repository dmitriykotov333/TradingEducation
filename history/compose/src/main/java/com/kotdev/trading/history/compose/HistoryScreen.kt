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
import androidx.compose.foundation.layout.BoxScope
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
        Profit(
            isEmpty = isEmpty,
            positive = positive,
            profitFormat = states.profitFormat
        )
    }
}

@Composable
internal fun BoxScope.Profit(
    isEmpty: Boolean,
    positive: Boolean,
    profitFormat: String
) {
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
                text = profitFormat,
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








