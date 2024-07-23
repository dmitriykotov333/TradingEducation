package com.kotdev.trading.trading.presentation.contact

sealed class ContactEvent {
    data class ChangeFirstName(val value: String) : ContactEvent()
    data class ChangeLastName(val value: String) : ContactEvent()
    data class ChangeMessage(val value: String) : ContactEvent()
    object SendClick: ContactEvent()
    object CloseClick: ContactEvent()
}