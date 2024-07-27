package com.kotdev.trading.service.data.di

import AppWriteDataSource
import androidx.lifecycle.viewmodel.compose.viewModel
import api.AppWriteRepository
import com.kotdev.trading.service.api.ServiceRepository
import com.kotdev.trading.service.data.KtorServiceDataSource
import io.ktor.client.HttpClient
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val serviceModule = DI.Module("serviceModule") {
    bind<AppWriteRepository>() with provider {
        AppWriteDataSource(instance())
    }

    bind<ServiceRepository>() with provider {
        KtorServiceDataSource(instance(), instance(), instance())
    }
}