package com.kotdev.trading.navigation.destination


import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.kotdev.trading.articles.compose.article.ArticleDetailScreen
import com.kotdev.trading.core.ArticleDetail
import com.kotdev.trading.core.Settings.articles
import com.kotdev.trading.core.navigation.AppGraph
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList



class ArticleDestination(
    private val list: ImmutableList<ArticleDetail>
) : Screen {

    @Composable
    override fun Content() {
        ArticleDetailScreen(list)
    }
}