package com.kotdev.trading.platform


import android.content.Context
import com.kotdev.trading.articles.presentation.viewModelModule
import com.kotdev.trading.core.di.Inject
import com.kotdev.trading.databaseModule
import com.kotdev.trading.history.data.historyModule
import com.kotdev.trading.service.data.di.ktorModule
import com.kotdev.trading.service.data.di.serviceModule
import com.kotdev.trading.trading.data.tradingModule
import di.appWriteModule
import org.kodein.di.Copy
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton



object PlatformSDK {

    fun init(
        configuration: DI.Module
    ) {

        Inject.createDependencies(
            DI {
                importAll(
                    configuration,
                    ktorModule,
                    databaseModule,
                    appWriteModule,
                    serviceModule,
                    tradingModule,
                    historyModule,
                    viewModelModule
                )
            }.direct
        )
    }
}