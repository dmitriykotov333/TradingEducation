package com.kotdev.trading.trading.presentation

import com.kotdev.trading.trading.model.SessionManager
import com.kotdev.trading.trading.model.entities.BasePair
import com.github.mikephil.charting.data.LineData
import com.kotdev.trading.BalanceDBO
import com.kotdev.trading.TradingDatabase
import com.kotdev.trading.core.Utils
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.trading.data.preferences.LocalePreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import com.kotdev.trading.trading.model.entities.EventTrading
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class TradingViewModel @Inject constructor(
    private val localePreferences: LocalePreferences,
    private val database: TradingDatabase,
    private val sessionManager: SessionManager
) : BaseViewModel<TradingViewState, TradingAction, TradingEvent>(
    initialState = TradingViewState(
        balance = 5000f,
        pairs = persistentListOf(),
        pair = BasePair(
            icon = R.drawable.usd_eur,
            pair = Utils.USD_EUR,
            currentPrice = 0f,
            percent = 0f,
            lineData = LineData()
        ),
    )
) {

    private val balanceDao = database.balanceDao

    init {
        coroutineScope.launch {
            balanceDao.balance().collectLatest {
                if (it != null) {
                    viewState = viewState.copy(
                        balance = it.balance.toFloat()
                    )
                }
            }
        }
        coroutineScope.launch {
            sessionManager.collectPair().collectLatest {
                viewState = viewState.copy(
                    pairs = it.toImmutableList(),
                )
            }
        }
        coroutineScope.launch {
            viewState = viewState.copy(
                locale = localePreferences.getLocale().first
            )
        }
        coroutineScope.launch {
            sessionManager.activePair().collectLatest {
                viewState = viewState.copy(pair = it)
            }
        }
        coroutineScope.launch {
            sessionManager.tradingPair().collectLatest {
                viewState = viewState.copy(tradingPair = it)
            }
        }
        coroutineScope.launch {
            sessionManager.eventTrading().collectLatest {
                when (it) {
                    is EventTrading.PopUp -> {
                        viewAction = TradingAction.FinishPopUp(it.tradingPair)
                    }
                }
            }
        }
    }

    override fun obtainEvent(viewEvent: TradingEvent) {
        when (viewEvent) {
            is TradingEvent.TradingStop -> {
                sessionManager.tradingStop(viewEvent.pair, viewEvent.closePrice)
            }

            is TradingEvent.TradingStart -> {
                sessionManager.tradingStart(viewEvent.pair, viewEvent.type)
            }

            is TradingEvent.SelectedPair -> {
                sessionManager.selectedPair(viewEvent.pair)
            }

            is TradingEvent.SelectedLocale -> {
                coroutineScope.launch {
                    if (localePreferences.getLocale().second != viewEvent.locale) {
                        if (localePreferences.getLocale().second == "en") {
                            localePreferences.saveLocale(viewEvent.language, viewEvent.locale)
                            viewAction = TradingAction.UpdateLocale(viewEvent.locale)
                        }
                        if (localePreferences.getLocale().second == "ru") {
                            localePreferences.saveLocale(viewEvent.language, viewEvent.locale)
                            viewAction = TradingAction.UpdateLocale(viewEvent.locale)
                        }
                    }
                    localePreferences.saveLanguage(viewEvent.language)
                    viewState = viewState.copy(
                        locale = viewEvent.language
                    )
                }
            }

            is TradingEvent.ContactClick -> {
                viewAction = TradingAction.ContactDialog
            }

            is TradingEvent.CloseAppClick -> {
                exitProcess(0)
            }

            is TradingEvent.InfoClick -> {
                viewAction = TradingAction.InfoPopUp
            }

            is TradingEvent.HistoryClick -> {
                viewAction = TradingAction.History
            }

            is TradingEvent.RefreshBalanceClick -> {
                if (viewState.balance < 1000) {
                    coroutineScope.launch(Dispatchers.IO) {
                        val balance = balanceDao
                        balance.clean()
                        balance.insert(BalanceDBO(3000.0))
                    }
                } else {
                    viewAction =
                        TradingAction.BalanceInfo(com.kotdev.trading.core_ui.R.string.balance_refresh_info)
                }
            }
        }
    }

}