package com.kotdev.trading.trading.data

import com.kotdev.trading.trading.model.SessionManager
import android.content.Context
import com.kotdev.trading.TradingDatabase
import com.kotdev.trading.trading.data.preferences.LocalePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TradingModule {

    @Provides
    @Singleton
    fun provideLocalePreferences(@ApplicationContext context: Context): LocalePreferences =
        LocalePreferences(context)


    @Provides
    @Singleton
    fun provideSessionManager(
        database: TradingDatabase
    ): SessionManager {
        return SessionManagerImpl(database.balanceDao, database.pairDao, database.historyDao)
    }


}