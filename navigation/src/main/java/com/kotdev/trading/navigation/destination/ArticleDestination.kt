package com.kotdev.trading.navigation.destination


//import androidx.compose.runtime.remember
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.compose.composable
//import com.onlinesimulator.tradingeducation.core.utils.Utils.articles
//import com.kotdev.trading.navigation.AppGraph
//import com.onlinesimulator.tradingeducation.presentation.detail.ArticleDetailScreen
//import kotlinx.collections.immutable.toImmutableList
//
//fun NavGraphBuilder.article() {
//    composable(
//        AppGraph.Article.fullRoute
//    ) {
//        val article = remember {
//            articles[requireNotNull(it.arguments).getString(AppGraph.Article.params!![0])?.toInt()
//                ?: 1].detail.toImmutableList()
//        }
//        ArticleDetailScreen(article)
//    }
//}