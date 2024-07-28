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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import com.kotdev.trading.core.ArticleDetail
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core_ui.component.HeaderContent
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
    val controller = LocalNavigator.currentOrThrow

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { articles.size }

    val visible by remember {
        derivedStateOf {
            pagerState.currentPage + 1 != pagerState.pageCount
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderContent {
            controller.pop()
        }
        Spacer(modifier = Modifier.height(15.dp))
        PagerIndicator(
            pageCount = pagerState.pageCount,
            currentPage = pagerState.currentPage
        )
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
        if (visible) {
            Spacer(modifier = Modifier.height(15.dp))
            PagerButton {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

