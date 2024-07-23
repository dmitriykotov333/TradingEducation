package com.kotdev.trading.trading.compose

import HistoryItem
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotdev.trading.core.helpers.LocaleHelper
import com.kotdev.trading.core.navigation.AppGraph
import com.kotdev.trading.core.navigation.AppNavigator
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.compose.buttons.ActiveTrade
import com.kotdev.trading.trading.compose.buttons.ButtonsTrade
import com.kotdev.trading.trading.compose.contents.GraphContent
import com.kotdev.trading.trading.compose.contents.HeaderContent
import com.kotdev.trading.trading.compose.contents.HistoryTradeContent
import com.kotdev.trading.trading.compose.contents.PairListContent
import com.kotdev.trading.trading.compose.contents.ProgressTradeContent
import com.kotdev.trading.trading.compose.contents.RatePairContent
import com.kotdev.trading.trading.compose.dialog.ContactDialog
import com.kotdev.trading.trading.compose.dialog.FinishDialog
import com.kotdev.trading.trading.compose.dialog.InfoPopUp
import com.kotdev.trading.trading.presentation.TradingAction
import com.kotdev.trading.trading.presentation.TradingEvent
import com.kotdev.trading.trading.presentation.TradingViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@Composable
fun TradingScreen(
    activity: Activity,
    viewModel: TradingViewModel = hiltViewModel()
) {

    val states by viewModel.states().collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        HeaderContent(
            activity = activity,
            state = states,
            eventHandler = viewModel::obtainEvent
        )
        Spacer(modifier = Modifier.height(10.dp))
        RatePairContent(state = states)
        Spacer(modifier = Modifier.height(10.dp))
        GraphContent(state = states)
        Spacer(modifier = Modifier.height(5.dp))
        ProgressTradeContent(
            progress = states.pair.progress!!,
            eventHandler = viewModel::obtainEvent
        )
        Spacer(modifier = Modifier.height(5.dp))
        if (states.tradingPair != null) {
            if (states.tradingPair!!.pair == states.pair.pair) {
                ActiveTrade(
                    state = states,
                    onStop = {
                        viewModel.obtainEvent(
                            TradingEvent.TradingStop(
                                states.pair.pair,
                                states.tradingPair!!.closePrice
                            )
                        )
                    }
                )
            } else {
                ButtonsTrade(
                    pair = states.pair.pair,
                    eventHandler = viewModel::obtainEvent
                )
            }
        } else {
            ButtonsTrade(
                pair = states.pair.pair,
                eventHandler = viewModel::obtainEvent
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        PairListContent(items = states.pairs, eventHandler = viewModel::obtainEvent)
        Spacer(modifier = Modifier.height(10.dp))
        HistoryTradeContent(
            eventHandler = viewModel::obtainEvent
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
    TradingAction(activity, viewModel)
}

@Composable
fun TradingAction(activity: Activity, viewModel: TradingViewModel) {

    val context = LocalContext.current

    val snackbarHostState = remember { SnackbarHostState() }

    var balanceInfo by remember {
        mutableStateOf("")
    }

    var contact by remember {
        mutableStateOf(false)
    }
    var finish by rememberSaveable {
        mutableStateOf<HistoryItem?>(null)
    }
    var info by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        viewModel.actions().collectLatest {
            when (it) {
                is TradingAction.UpdateLocale -> {
                    LocaleHelper.setLocale(activity, it.language)
                }


                is TradingAction.ContactDialog -> {
                    contact = true
                }

                is TradingAction.InfoPopUp -> {
                    info = true
                }

                is TradingAction.FinishPopUp -> {
                    finish = it.data
                }

                is TradingAction.BalanceInfo -> {
                    balanceInfo = context.getString(it.msg)
                }

                is TradingAction.History -> {
                    AppNavigator.push(
                        controller = AppGraph.App,
                        to = AppGraph.History
                    )
                }
            }
        }
    }
    LaunchedEffect(key1 = balanceInfo) {
        if (balanceInfo.isNotEmpty()) {
            snackbarHostState.showSnackbar(balanceInfo)
            delay(3000)
            balanceInfo = ""
        }
    }
    Box {
        SnackbarHost(hostState = snackbarHostState) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            )
            {
                Text(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .background(Theme.colors.neutralBlack, RoundedCornerShape(10.dp))
                        .padding(10.dp)
                        .align(Alignment.BottomCenter),
                    text = balanceInfo,
                    style = TextStyle(
                        color = Color.White,
                        lineHeight = 23.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
        }
    }
    if (finish != null) {
        FinishDialog(
            item = finish!!,
            setShowDialog = {
                finish = null
            }
        )
    }
    if (contact) {
        ContactDialog(setShowDialog = {
            contact = false
        })
    }
    if (info) {
        InfoPopUp(onDismissRequest = {
            info = false
        })
    }
}











