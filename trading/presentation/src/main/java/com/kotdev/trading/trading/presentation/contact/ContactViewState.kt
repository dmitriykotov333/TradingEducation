package com.kotdev.trading.trading.presentation.contact

import androidx.compose.runtime.Immutable


@Immutable
data class ContactViewState(
    val firstName: String = "",
    val lastName: String = "",
    val message: String = "",
    val isSending: Boolean = false,
    val error: String = ""
)