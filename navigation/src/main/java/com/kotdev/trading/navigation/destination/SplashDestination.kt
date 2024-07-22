package com.kotdev.trading.navigation.destination


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.splash.compose.SplashScreen

fun NavGraphBuilder.splash() {
    composable(
        AppGraph.Splash.route
    ) {
        SplashScreen()
    }
}