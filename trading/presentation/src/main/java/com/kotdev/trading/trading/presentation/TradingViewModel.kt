package com.kotdev.trading.trading.presentation

import androidx.compose.ui.unit.dp
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.Entry
import com.kotdev.trading.trading.model.SessionManager
import com.kotdev.trading.trading.model.entities.BasePair
import com.github.mikephil.charting.data.LineData
import com.kotdev.trading.BalanceDBO
import com.kotdev.trading.TradingDatabase
import com.kotdev.trading.core.Utils
import com.kotdev.trading.core.di.Inject
import com.kotdev.trading.core.viewmodel.BaseViewModel
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.trading.data.preferences.LocalePreferences
import com.kotdev.trading.trading.model.entities.Coordinate
import com.kotdev.trading.trading.model.entities.EventTrading
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class TradingViewModel : BaseViewModel<TradingViewState, TradingAction, TradingEvent>(
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

    private val localePreferences = Inject.instance<LocalePreferences>()
    private val database = Inject.instance<TradingDatabase>()
    private val sessionManager = Inject.instance<SessionManager>()

    private val balanceDao = database.balanceDao
    var lineChart: LineChart? = null

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
                if (lineChart != null) {
                    if (lineChart!!.data != null) {
                        val entry: Entry = it.lineData.dataSets.last()
                            .getEntryForIndex(it.lineData.dataSets.last().entryCount - 1)
                        val positionY = lineChart!!.getPosition(
                            entry,
                            AxisDependency.RIGHT
                        ).y
                        val positionX = lineChart!!.getPosition(
                            entry,
                            AxisDependency.RIGHT
                        ).x

                        val y = if (positionY > 0) {
                            positionY.toInt() - 20.dp.value
                        } else {
                            it.coordinate.y
                        }
                        viewState = viewState.copy(
                            pair = it.copy(
                                coordinate = Coordinate(
                                    x = positionX,
                                    value = entry.y,
                                    y = y
                                )
                            )
                        )
                    } else {
                        viewState = viewState.copy(
                            pair = it
                        )
                    }

                }else {
                    viewState = viewState.copy(
                        pair = it
                    )
                }
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