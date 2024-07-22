package com.kotdev.trading.service.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Exchange(
    @SerialName("time_next_update_unix") val timeNextUpdateUnix: Long,
    @SerialName("conversion_rates") val conversionRates: ConversionRates,
    @SerialName("result") val result: String,
)