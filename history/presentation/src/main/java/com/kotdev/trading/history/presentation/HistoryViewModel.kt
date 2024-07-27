package com.kotdev.trading.history.presentation

import com.kotdev.trading.core.di.Inject
import com.kotdev.trading.core.extensions.chartFormatFloat
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.history.data.HistoryUseCase
import com.kotdev.trading.history.data.mapToUI
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class HistoryViewModel: BaseViewModel<HistoryViewState, Nothing, Nothing>(
    initialState = HistoryViewState()
) {

    private val historyUseCase = Inject.instance<HistoryUseCase>()

    val historyPagingSource = historyUseCase
        .call()
        .map { history ->
            history.map {
                it.mapToUI()
            }
        }.stateIn(coroutineScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        coroutineScope.launch {
            val profit = historyUseCase.getProfit()
            if (profit != null) {
                viewState = viewState.copy(
                    profit = profit.toFloat(),
                    profitFormat =
                    "${
                        if (profit >= 0) "+${
                            profit.toFloat().chartFormatFloat()
                        }" else profit.toFloat().chartFormatFloat()
                    }\$"
                )
            }
        }
    }

    override fun obtainEvent(viewEvent: Nothing) {

    }


}