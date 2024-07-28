package com.kotdev.trading.articles.presentation

import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.kotdev.trading.core.Settings
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.viewmodel.BaseViewModel


class SettingsViewModel : BaseViewModel<SettingsViewState, Nothing, SettingsEvent>(
    initialState = SettingsViewState(
        items = Settings.articles,
        faqs = Settings.faqs
    )
) {

    override fun obtainEvent(viewEvent: SettingsEvent) {
        when (viewEvent) {
            is SettingsEvent.BackClick -> {
                voyagerRouter.back()
            }

            is SettingsEvent.ItemClick -> {
                when (viewEvent.index) {
                    0 -> {
                        voyagerRouter.navigateTo(AppGraph.Faq)
                    }

                    else -> {
                        voyagerRouter.navigateTo(AppGraph.Article(viewEvent.index))
                    }
                }
            }
        }
    }

}