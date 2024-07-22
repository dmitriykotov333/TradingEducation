package com.kotdev.trading

import android.content.Context
import com.kotdev.trading.preferences.LocalePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalePreferences(@ApplicationContext context: Context): LocalePreferences =
        LocalePreferences(context)

}
