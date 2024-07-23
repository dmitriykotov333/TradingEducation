package com.kotdev.trading.trading.presentation.contact

import android.content.Context
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.trading.presentation.contact.ContactAction
import com.kotdev.trading.trading.presentation.contact.ContactEvent
import com.kotdev.trading.trading.presentation.contact.ContactViewState
import com.kotdev.trading.core_ui.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : BaseViewModel<ContactViewState, ContactAction, ContactEvent>(
    initialState = ContactViewState()
) {

    override fun obtainEvent(viewEvent: ContactEvent) {
        when (viewEvent) {
            is ContactEvent.ChangeFirstName -> {
                viewState = viewState.copy(firstName = viewEvent.value, error = "")
            }

            is ContactEvent.ChangeLastName -> {
                viewState = viewState.copy(lastName = viewEvent.value, error = "")
            }

            is ContactEvent.ChangeMessage -> {
                viewState = viewState.copy(message = viewEvent.value, error = "")
            }

            is ContactEvent.SendClick -> {
                if (viewState.firstName.isEmpty() || viewState.lastName.isEmpty() || viewState.message.isEmpty()) {
                    coroutineScope.launch {
                        viewState =
                            viewState.copy(error = context.getString(R.string.contact_error))
                        delay(3000)
                        viewState = viewState.copy(error = "")
                    }

                } else {
                    coroutineScope.launch {
                        viewState = viewState.copy(error = context.getString(R.string.message_sent))
                        delay(1000)
                        viewState = viewState.copy(error = "")
                        viewAction = ContactAction.Close
                    }
                }
            }

            is ContactEvent.CloseClick -> {
                viewAction = ContactAction.Close
            }
        }
    }

}