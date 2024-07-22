package com.kotdev.trading.history.data

import android.content.Context
import com.kotdev.trading.HistoryDao
import com.kotdev.trading.TradingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object HistoryModule {

    @Provides
    @ViewModelScoped
    fun provideHistory(
        database: TradingDatabase
    ): HistoryRepository {
        return HistoryRepository(database.historyDao)
    } 
}