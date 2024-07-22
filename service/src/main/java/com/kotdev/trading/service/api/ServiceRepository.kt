package com.kotdev.trading.service.api

import com.kotdev.trading.core.BasePair
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {
    fun getConversionRates(): Flow<ApiResult<List<BasePair>>>
}