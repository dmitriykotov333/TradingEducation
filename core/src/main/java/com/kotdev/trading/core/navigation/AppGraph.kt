package com.kotdev.trading.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import com.kotdev.trading.core.Utils.APP_GRAPH
import com.kotdev.trading.core.Utils.ARTICLE
import com.kotdev.trading.core.Utils.FAQ
import com.kotdev.trading.core.Utils.HISTORY
import com.kotdev.trading.core.Utils.SETTINGS
import com.kotdev.trading.core.Utils.SPLASH
import com.kotdev.trading.core.Utils.TRADING

sealed class SharedScreen : ScreenProvider {
    object PostList : SharedScreen()
    data class PostDetails(val id: String) : SharedScreen()
}
sealed class AppGraph: ScreenProvider {


    object App : AppGraph()


    object Splash : AppGraph()


    object Trading : AppGraph()


    object History : AppGraph()


    object Settings : AppGraph()


    object Faq : AppGraph()


    data class Article(val id: Int) : AppGraph()
}