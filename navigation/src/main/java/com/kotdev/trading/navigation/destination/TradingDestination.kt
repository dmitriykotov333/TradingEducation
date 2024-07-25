package com.kotdev.trading.navigation.destination


import android.app.Activity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.trading.compose.TradingScreen


fun NavGraphBuilder.trading(activity: Activity) {
    composable(
        AppGraph.Trading.route
    ) {
        TradingScreen(activity)
    }
}