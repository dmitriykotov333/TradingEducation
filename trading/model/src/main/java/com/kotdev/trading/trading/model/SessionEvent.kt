package com.kotdev.trading.trading.model

import com.kotdev.trading.trading.model.entities.EventTrading
import kotlinx.coroutines.flow.SharedFlow

interface SessionEvent {
    fun eventTrading(): SharedFlow<EventTrading>
}