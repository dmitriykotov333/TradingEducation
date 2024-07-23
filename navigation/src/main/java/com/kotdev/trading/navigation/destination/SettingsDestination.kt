package com.kotdev.trading.navigation.destination


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotdev.trading.articles.compose.settings.SettingsScreen
import com.kotdev.trading.core.navigation.AppGraph

fun NavGraphBuilder.settings() {
    composable(
        AppGraph.Settings.route
    ) {
        SettingsScreen()
    }
}