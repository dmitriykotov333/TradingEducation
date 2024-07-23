package com.kotdev.trading.trading.compose.dialog

import HistoryItem
import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.WindowCompat
import coil.compose.AsyncImage
import com.kotdev.trading.core.extensions.chartFormatFloat
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme

@Composable
fun getScreenWidthDp(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}

@Composable
fun getScreenDp(): androidx.compose.ui.geometry.Size {
    val configuration = LocalConfiguration.current
    return androidx.compose.ui.geometry.Size(
        configuration.screenWidthDp.toFloat(),
        configuration.screenHeightDp.toFloat()
    )
}

@Composable
fun getScreenHeightDp(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp
}

@Composable
fun isTablet(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp >= 600
}

@SuppressLint("ProduceStateDoesNotAssignValue", "UnrememberedAnimatable")
@Composable
fun FinishDialog(
    item: HistoryItem,
    setShowDialog: (Boolean) -> Unit,
) {
    val screenWidthDp = getScreenWidthDp()
    Dialog(
        onDismissRequest = {
            setShowDialog(false)
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false,
        ),
    ) {
        (LocalView.current.parent as? DialogWindowProvider)?.window?.let { window ->
            WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
                true
            window.setWindowAnimations(-1)
            window.setDimAmount(0f)
        }
        val scale by produceState(initialValue = Animatable(.5f)) {
            value.animateTo(
                1f,
                animationSpec = tween(
                    durationMillis = 400,
                    easing = LinearEasing
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = scale.value
                    scaleY = scale.value
                },
            contentAlignment = Alignment.TopCenter
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),
                model = R.drawable.dialog_back,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = if (screenWidthDp < 600) {
                            50.dp
                        } else {
                            120.dp
                        }, vertical = 50.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 110.dp, end = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color(0xFF323234), RoundedCornerShape(10.dp))
                            .padding(horizontal = 15.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            modifier = Modifier,
                            model = item.icon,
                            contentDescription = item.icon.toString(),
                            contentScale = ContentScale.Crop,
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            modifier = Modifier,
                            text = item.pair,
                            style = TextStyle(
                                color = Theme.colors.neutralWhite,
                                lineHeight = 24.sp,
                                fontSize = 16.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier,
                            text = stringResource(R.string.trade_time),
                            style = TextStyle(
                                color = Theme.colors.pairColor,
                                lineHeight = 14.sp,
                                fontSize = 9.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(
                                            Color(0xFF191F1F), Color(0xFF143530)
                                        )
                                    ),
                                    RoundedCornerShape(10.dp)
                                )
                                .padding(horizontal = 15.dp, vertical = 6.dp),
                            text = item.closeTime,
                            style = TextStyle(
                                color = Theme.colors.neutralWhite,
                                lineHeight = 24.sp,
                                fontSize = 16.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier,
                            text = stringResource(R.string.trade_open_price),
                            style = TextStyle(
                                color = Theme.colors.pairColor,
                                lineHeight = 14.sp,
                                fontSize = 9.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(
                                            Color(0xFF191F1F), Color(0xFF143530)
                                        )
                                    ),
                                    RoundedCornerShape(10.dp)
                                )
                                .padding(horizontal = 15.dp, vertical = 6.dp),
                            text = item.openPrice.toFloat().chartFormatFloat(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Theme.colors.neutralWhite,
                                lineHeight = 24.sp,
                                fontSize = 16.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier,
                            text = stringResource(R.string.trade_close_price),
                            style = TextStyle(
                                color = Theme.colors.pairColor,
                                lineHeight = 14.sp,
                                fontSize = 9.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(
                                            Color(0xFF2C4B48), Color(0xFF199B87)
                                        )
                                    ),
                                    RoundedCornerShape(10.dp)
                                )
                                .padding(horizontal = 15.dp, vertical = 6.dp),
                            text = item.closePrice.toFloat().chartFormatFloat(),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Theme.colors.neutralWhite,
                                lineHeight = 24.sp,
                                fontSize = 16.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.profit),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 14.sp,
                        fontSize = 9.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                if (item.profit >= 0) listOf(
                                    Color(0xFF1B2418), Color(0xFF304926)
                                ) else listOf(Color(0xFF271C1C), Color(0xFF503030))
                            ),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 7.dp),
                    text = "${
                        if (item.profit >= 0) "+${
                            item.profit.toFloat().chartFormatFloat()
                        }" else item.profit.toFloat().chartFormatFloat()
                    }\$",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = if (item.profit >= 0) Theme.colors.green else Theme.colors.red,
                        lineHeight = 39.sp,
                        fontSize = 26.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold
                    ),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .bounceClick(from = .94f)
                        .background(
                            Theme.colors.neutralBlack,
                            RoundedCornerShape(10.dp)
                        )
                        .border(
                            BorderStroke(1.dp, Theme.colors.pairColor),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 30.dp, vertical = 7.dp)
                        .noRippleClickable {
                            setShowDialog(false)
                        },
                    text = stringResource(R.string.back),
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
        }
    }
}
