package com.kotdev.trading.navigation.destination


import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotdev.trading.articles.compose.article.ArticleDetailScreen
import com.kotdev.trading.core.Settings.articles
import com.kotdev.trading.core.navigation.AppGraph
import kotlinx.collections.immutable.toImmutableList

fun NavGraphBuilder.article() {
    composable(
        AppGraph.Article.fullRoute
    ) {
        ArticleDetailScreen(
            articles[requireNotNull(it.arguments).getString(AppGraph.Article.params!![0])?.toInt()
                ?: 1].detail.toImmutableList()
        )
    }
}