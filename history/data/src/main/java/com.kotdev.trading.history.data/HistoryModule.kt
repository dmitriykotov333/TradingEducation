package com.kotdev.trading.history.data

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton


val historyModule = DI.Module("historyModule") {

    bind<HistoryRepository>() with provider {
        HistoryRepository(instance())
    }

    bind<HistoryUseCase>() with provider {
        HistoryUseCase()
    }

}