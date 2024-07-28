package com.kotdev.trading.navigation.destination


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.kotdev.trading.core.navigation.VoyagerEvent
import com.kotdev.trading.splash.compose.SplashScreen
import com.kotdev.trading.splash.presentation.SplashViewModel

class SplashDestination : Screen {

    @Composable
    override fun Content() {
        val viewModel = viewModel<SplashViewModel>()
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
        SplashScreen(viewModel)
    }
}