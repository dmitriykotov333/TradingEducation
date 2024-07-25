package com.kotdev.trading.trading.model

import com.kotdev.trading.trading.model.entities.BasePair
import kotlinx.coroutines.flow.SharedFlow

interface SessionAction {
    fun activePair(): SharedFlow<BasePair>
}