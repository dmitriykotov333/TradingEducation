package com.kotdev.trading.navigation.destination


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.history.compose.HistoryScreen

fun NavGraphBuilder.history() {
    composable(
        AppGraph.History.route
    ) {
        HistoryScreen()
    }
}