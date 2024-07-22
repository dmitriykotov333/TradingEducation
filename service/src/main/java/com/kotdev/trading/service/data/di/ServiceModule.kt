package com.kotdev.trading.service.data.di

import AppWriteDataSource
import api.AppWriteRepository
import com.kotdev.trading.service.api.ServiceRepository
import com.kotdev.trading.PairDao
import com.kotdev.trading.TradingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import com.kotdev.trading.service.data.KtorServiceDataSource
import io.appwrite.services.Databases
import io.ktor.client.HttpClient

@Module
@InstallIn(ViewModelComponent::class)
object ServiceModule {


    @Provides
    @ViewModelScoped
    fun provideAppWriteDataSource(databases: Databases): AppWriteRepository =
        AppWriteDataSource(databases)

    @Provides
    @ViewModelScoped
    fun provideServiceKtor(
        httpClient: HttpClient,
        database: TradingDatabase,
        appWrite: AppWriteRepository
    ): ServiceRepository =
        KtorServiceDataSource(httpClient, database.pairDao, appWrite)

}