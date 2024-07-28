package com.kotdev.trading.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotdev.trading.core.navigation.VoyagerRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import java.io.Closeable

abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) : ViewModel() {

    val coroutineScope: CoroutineScope = viewModelScope

    val voyagerRouter = VoyagerRouter()

    private val viewStates = MutableStateFlow(initialState)

    private val viewActions: Channel<Action> = Channel(
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        capacity = 1
    )

    fun states(): WrappedStateFlow<State> = WrappedStateFlow(viewStates.asStateFlow())


    fun actions(): Flow<Action> = viewActions.receiveAsFlow()

    var viewState: State
        get() = viewStates.value
        set(value) {
            viewStates.update {
                value
            }
        }

    var viewAction: Action
        get() = viewAction
        set(value) {
            viewActions.trySend(value)
        }

    abstract fun obtainEvent(viewEvent: Event)

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}