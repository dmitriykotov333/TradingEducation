package com.kotdev.trading.articles.presentation

import com.kotdev.trading.core.Settings
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppGraph.App.invoke
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.core.viewmodel.BaseViewModel


class SettingsViewModel: BaseViewModel<SettingsViewState, Nothing, SettingsEvent>(
    initialState = SettingsViewState(
        items = Settings.articles,
        faqs = Settings.faqs
    )
) {

    override fun obtainEvent(viewEvent: SettingsEvent) {
        when(viewEvent) {
            is SettingsEvent.BackClick -> {
                AppNavigator.back(AppGraph.App)
            }
            is SettingsEvent.ItemClick -> {
                when(viewEvent.index) {
                    0 -> {
                        AppNavigator.push(
                            controller = AppGraph.App,
                            to = AppGraph.Faq
                        )
                    }
                    else -> {
                        AppNavigator.push(
                            controller = AppGraph.App,
                            to = AppGraph.Article.route.invoke(
                                viewEvent.index.toString()
                            )
                        )
                    }
                }
            }
        }
    }

}