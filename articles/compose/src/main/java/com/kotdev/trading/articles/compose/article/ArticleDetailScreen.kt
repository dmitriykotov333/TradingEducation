package com.kotdev.trading.articles.compose.article

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kotdev.trading.core.ArticleDetail
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArticleDetailScreen(
    articles: ImmutableList<ArticleDetail>
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { articles.size }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    fontWeight = FontWeight.Normal
                ),
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color(0xFF22DBBB) else Color(
                        0xFF323234
                    )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .weight(1f)
                        .background(color, RoundedCornerShape(10.dp))
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            state = pagerState,
            key = {
                articles[it].title
            },
            beyondBoundsPageCount = 1,
            userScrollEnabled = false,
            verticalAlignment = Alignment.CenterVertically,
        ) { page ->
            ArticleItem(articles[page])
        }
        if (pagerState.currentPage + 1 != pagerState.pageCount) {
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .bounceClick(from = .91f)
                    .background(
                        Theme.colors.greenDark,
                        RoundedCornerShape(10.dp)
                    ).noRippleClickable {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 50.dp, vertical = 5.dp),
                    text = stringResource(com.kotdev.trading.core_ui.R.string.next),
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal
                    ),
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
internal fun ArticleItem(
    item: ArticleDetail
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    BorderStroke(1.dp, Color(0xFF3B3B3B)), RoundedCornerShape(10.dp)
                ),
            model = item.background,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(item.title),
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Theme.colors.pairColor,
                lineHeight = 26.sp,
                fontSize = 21.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier,
            text = stringResource(item.description),
            style = TextStyle(
                color = Theme.colors.pairColor,
                lineHeight = 26.sp,
                fontSize = 17.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal
            ),
        )
    }
}