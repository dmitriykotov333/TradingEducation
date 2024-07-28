package com.kotdev.trading.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import com.kotdev.trading.core.Settings.articles
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.navigation.destination.ArticleDestination
import com.kotdev.trading.navigation.destination.FaqDestination
import com.kotdev.trading.navigation.destination.HistoryDestination
import com.kotdev.trading.navigation.destination.SettingsDestination
import com.kotdev.trading.navigation.destination.SplashDestination
import com.kotdev.trading.navigation.destination.TradingDestination

fun ScreenRegistry() {
    ScreenRegistry {
        register<AppGraph.Splash> {
            SplashDestination()
        }
        register<AppGraph.Trading> {
           TradingDestination()
        }
        register<AppGraph.History> {
            HistoryDestination()
        }
        register<AppGraph.Settings> {
            SettingsDestination()
        }
        register<AppGraph.Faq> {
            FaqDestination()
        }
        register<AppGraph.Article> { provider ->
            ArticleDestination(articles[provider.id].detail)
        }
    }
}

@Composable
fun GenerateGraph(activity: Activity) {
    Navigator(SplashDestination())

}