package com.kotdev.trading.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.navigation.destination.history
import com.kotdev.trading.navigation.destination.splash


@Composable
fun generateGraph(activity: Activity) {
    val navController = rememberNavController()
    AppNavigator.addGraph(AppGraph.App.route, navController)
    NavHost(
        navController = navController,
        startDestination = AppGraph.Splash.route
    ) {
        splash()
       // trading(activity)
        history()
        //settings()
       // faq()
        //article()
    }
}