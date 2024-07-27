package com.kotdev.trading.articles.presentation

import androidx.lifecycle.ViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider


val viewModelModule = DI.Module("viewModel") {
    bindViewModel<SettingsViewModel>() with provider {
        SettingsViewModel()
    }
}



inline fun <reified VM : ViewModel> DI.Builder.bindViewModel(overrides: Boolean? = null): DI.Builder.TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, overrides)
}

