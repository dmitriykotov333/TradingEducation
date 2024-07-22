package com.kotdev.trading.service.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversionRates(
    @SerialName("CAD") val cad: Double,
    @SerialName("CHF") val chf: Double,
    @SerialName("EUR") val eur: Double,
    @SerialName("JPY") val jpy: Double,
    @SerialName("NZD") val nzd: Double,
    @SerialName("USD") val usd: Double,
)