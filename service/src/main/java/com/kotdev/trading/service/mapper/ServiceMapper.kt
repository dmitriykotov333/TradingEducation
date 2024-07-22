package com.kotdev.trading.service.mapper

import com.kotdev.trading.core.BasePair
import com.kotdev.trading.core.Utils.DEFAULT_VALUE
import com.kotdev.trading.core.Utils.USD_CAD
import com.kotdev.trading.core.Utils.USD_CHF
import com.kotdev.trading.core.Utils.USD_EUR
import com.kotdev.trading.core.Utils.USD_JPY
import com.kotdev.trading.core.Utils.USD_NZD
import com.kotdev.trading.service.api.models.Exchange
import com.kotdev.trading.PairDBO
import io.appwrite.models.Document


internal fun Exchange.mapToPairs() = listOf(
    BasePair(
        pair = USD_EUR,
        value = conversionRates.eur,
        timeNextUpdate = timeNextUpdateUnix.toString()
    ),
    BasePair(
        pair = USD_JPY,
        value = conversionRates.jpy,
        timeNextUpdate = timeNextUpdateUnix.toString()
    ),
    BasePair(
        pair = USD_CHF,
        value = conversionRates.chf,
        timeNextUpdate = timeNextUpdateUnix.toString()
    ),
    BasePair(
        pair = USD_CAD,
        value = conversionRates.cad,
        timeNextUpdate = timeNextUpdateUnix.toString()
    ),
    BasePair(
        pair = USD_NZD,
        value = conversionRates.nzd,
        timeNextUpdate = timeNextUpdateUnix.toString()
    )
)

internal fun mapToDefaultList(): List<PairDBO> {
    return listOf(
        PairDBO(pair = USD_EUR, value = DEFAULT_VALUE, timeNextUpdate = "-1"),
        PairDBO(pair = USD_JPY, value = DEFAULT_VALUE, timeNextUpdate = "-1"),
        PairDBO(pair = USD_CHF, value = DEFAULT_VALUE, timeNextUpdate = "-1"),
        PairDBO(pair = USD_CAD, value = DEFAULT_VALUE, timeNextUpdate = "-1"),
        PairDBO(pair = USD_NZD, value = DEFAULT_VALUE, timeNextUpdate = "-1")
    )
}

internal fun Document<Map<String, Any>>.mapDocumentToPair(): BasePair {
    return BasePair(
        pair = this.data.getValue("pair") as String,
        value = this.data.getValue("value") as Double,
        timeNextUpdate = this.data.getValue("time_next_update") as String
    )
}

internal fun BasePair.mapToPairDBO(): PairDBO {
    return PairDBO(
        pair = this.pair,
        value = this.value,
        timeNextUpdate = this.timeNextUpdate
    )
}

internal fun PairDBO.mapToPair(): BasePair {
    return BasePair(
        pair = this.pair,
        value = this.value,
        timeNextUpdate = this.timeNextUpdate
    )
}