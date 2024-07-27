package com.kotdev.trading.viewModel

import androidx.lifecycle.viewModelScope
import com.kotdev.trading.core.di.Inject
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.trading.data.preferences.LocalePreferences
import kotlinx.coroutines.launch


class MainViewModel : BaseViewModel<Unit, MainAction, Nothing>(
    initialState = Unit
) {

    private val localePreferences = Inject.instance<LocalePreferences>()
    
    override fun obtainEvent(viewEvent: Nothing) = Unit


    init {
        viewModelScope.launch {
            viewAction = MainAction.Recreate(localePreferences.getLocale().second)
        }
    }
}