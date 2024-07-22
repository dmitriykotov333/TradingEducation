package com.kotdev.trading.viewModel

import androidx.lifecycle.viewModelScope
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.preferences.LocalePreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val localePreferences: LocalePreferences,
) : BaseViewModel<Unit, MainAction, Nothing>(
    initialState = Unit
) {
    override fun obtainEvent(viewEvent: Nothing) = Unit


    init {
        viewModelScope.launch {
            viewAction = MainAction.Recreate(localePreferences.getLocale().second)
        }
    }
}