package com.kotdev.trading.helpers;

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import com.kotdev.trading.MainActivity
import java.util.Locale


object LocaleHelper {
    fun setLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        (context as MainActivity).recreate()
    }


}