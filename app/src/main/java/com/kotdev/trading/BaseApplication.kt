package com.kotdev.trading

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.kotdev.trading.navigation.GenerateGraph
import com.kotdev.trading.navigation.ScreenRegistry
import com.kotdev.trading.platform.PlatformSDK
import org.kodein.di.android.x.androidXModule

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PlatformSDK.init(
            androidXModule(this)
        )
        ScreenRegistry()
    }
}