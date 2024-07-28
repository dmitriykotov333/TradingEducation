package com.kotdev.trading.navigation.destination



import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.kotdev.trading.articles.compose.settings.SettingsScreen
import com.kotdev.trading.articles.presentation.SettingsViewModel
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.VoyagerEvent
import com.kotdev.trading.history.compose.HistoryScreen
import com.kotdev.trading.history.presentation.HistoryViewModel

class HistoryDestination : Screen {

    @Composable
    override fun Content() {
        val viewModel = viewModel<HistoryViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(Unit) {
            viewModel.voyagerRouter.events()
                .collect { event ->
                    when (event) {
                        is VoyagerEvent.NavigateTo -> navigator.push(
                            ScreenRegistry.get(event.screen)
                        )

                        is VoyagerEvent.NewRootScreen -> navigator.replaceAll(
                            ScreenRegistry.get(event.screen)
                        )

                        is VoyagerEvent.Back -> navigator.pop()
                    }
                }
        }
        HistoryScreen(viewModel)
    }
}