package com.kotdev.trading.core.navigation

import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class VoyagerRouter {
    private val sharedFlow = MutableSharedFlow<VoyagerEvent>(extraBufferCapacity = 1)

    fun events(): SharedFlow<VoyagerEvent> {
        return sharedFlow.asSharedFlow()
    }

    fun navigateTo(screen: AppGraph) {
        sharedFlow.tryEmit(VoyagerEvent.NavigateTo(screen))
    }

    fun newRootScreen(screen: AppGraph) {
        sharedFlow.tryEmit(VoyagerEvent.NewRootScreen(screen))
    }

    fun back() {
        sharedFlow.tryEmit(VoyagerEvent.Back)
    }
}

sealed class VoyagerEvent {
    data class NavigateTo(val screen: AppGraph) : VoyagerEvent()
    data class NewRootScreen(val screen: AppGraph) : VoyagerEvent()
    data object Back : VoyagerEvent()
}