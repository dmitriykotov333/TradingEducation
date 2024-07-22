package com.kotdev.trading.core.navigation

import com.kotdev.trading.core.Utils.APP_GRAPH
import com.kotdev.trading.core.Utils.ARTICLE
import com.kotdev.trading.core.Utils.FAQ
import com.kotdev.trading.core.Utils.HISTORY
import com.kotdev.trading.core.Utils.SETTINGS
import com.kotdev.trading.core.Utils.SPLASH
import com.kotdev.trading.core.Utils.TRADING


sealed class AppGraph(open val route: String, open val params: Array<String>? = emptyArray()) {


    object App : AppGraph(APP_GRAPH)


    object Splash : AppGraph(SPLASH)


    object Trading : AppGraph(TRADING)


    object History : AppGraph(HISTORY)


    object Settings : AppGraph(SETTINGS)


    object Faq : AppGraph(FAQ)


    object Article : AppGraph(ARTICLE, arrayOf("article"))

    val fullRoute: String = if (params!!.isEmpty()) route else {
        val builder = StringBuilder(route)
        params!!.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    fun String.invoke(
        article: String,
    ): String = this.appendParams(
        "article" to article,
    )
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}