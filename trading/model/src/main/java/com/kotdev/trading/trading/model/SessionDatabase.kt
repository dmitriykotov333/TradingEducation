package com.kotdev.trading.trading.model

import com.kotdev.trading.trading.model.entities.PairItem
import kotlinx.coroutines.flow.SharedFlow

interface SessionDatabase {
    fun collectPair(): SharedFlow<List<PairItem>>
}