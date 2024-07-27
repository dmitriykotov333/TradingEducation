package com.kotdev.trading.trading.data

import com.kotdev.trading.trading.data.preferences.LocalePreferences
import com.kotdev.trading.trading.model.SessionManager
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton


val tradingModule = DI.Module("tradingModule") {
    bind<LocalePreferences>() with singleton {
        LocalePreferences(instance())
    }

    bind<SessionManager>() with singleton {
        SessionManagerImpl(instance())
    }
}