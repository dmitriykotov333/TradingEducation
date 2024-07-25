package com.kotdev.trading.trading.compose.contents

import com.kotdev.trading.trading.model.entities.PairItem
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.presentation.TradingEvent
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PairListContent(
    items: ImmutableList<PairItem>,
    eventHandler: (TradingEvent) -> Unit
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { items.size }



    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = {
            scope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            }
        }) {
            Image(
                modifier = Modifier.size(14.dp),
                painter = painterResource(R.drawable.arrow),
                contentDescription = null
            )
        }

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            state = pagerState,
            userScrollEnabled = false,
            verticalAlignment = Alignment.CenterVertically,
            pageSize = PageSize.Fixed(95.dp),
            pageSpacing = 8.dp
        ) { page ->

            PairItem(items[page], eventHandler)
        }
        IconButton(onClick = {
            scope.launch {
                if (pagerState.currentPage < 2) {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }) {
            Image(
                modifier = Modifier
                    .size(14.dp)
                    .graphicsLayer {
                        rotationY = 180f
                    },
                painter = painterResource(R.drawable.arrow),
                contentDescription = null
            )
        }
    }
}


@Composable
fun PairItem(
    item: PairItem,
    eventHandler: (TradingEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .bounceClick(from = .9f)
            .background(Theme.colors.neutralBlack, RoundedCornerShape(10.dp))
            .padding(10.dp)
            .noRippleClickable {
                eventHandler.invoke(TradingEvent.SelectedPair(item.name))
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier,
            painter = painterResource(item.icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier,
            text = item.name,
            style = TextStyle(
                color = Theme.colors.neutralWhite,
                lineHeight = 14.sp,
                fontSize = 9.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            ),
        )
    }
}