package com.kotdev.trading.navigation.destination


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotdev.trading.articles.compose.faq.FaqScreen
import com.kotdev.trading.core.navigation.AppGraph

fun NavGraphBuilder.faq() {
    composable(
        AppGraph.Faq.route
    ) {
        FaqScreen()
    }
}