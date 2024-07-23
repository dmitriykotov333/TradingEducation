package com.kotdev.trading.trading.compose.menu

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.presentation.TradingEvent
import kotlinx.collections.immutable.persistentListOf

@Composable
fun DropDownMenu(
    activity: Activity,
    locale: String,
    expanded: Boolean,
    eventHandler: (TradingEvent) -> Unit,
    onDismissRequest: () -> Unit
) {
    val context = LocalContext.current

    var open by remember {
        mutableStateOf(false)
    }
    val menu by rememberUpdatedState(newValue = expanded)
    if (menu) {
        Popup(
            offset = IntOffset(80, 160),
            alignment = Alignment.TopStart,
            properties = PopupProperties(
                excludeFromSystemGesture = true,
            ),
            onDismissRequest = onDismissRequest
        ) {
            Column(
                modifier = Modifier
                    .background(Theme.colors.neutralBlack, RoundedCornerShape(10.dp))
                    .border(1.dp, Theme.colors.pairColor, RoundedCornerShape(10.dp))
                    .padding(15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .bounceClick(from = .999f)
                        .noRippleClickable {
                            open = !open
                        }
                        .background(
                            Theme.colors.neutralBlack,
                            RoundedCornerShape(10.dp)
                        )
                        .border(1.dp, Theme.colors.pairColor, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 7.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.language, locale),
                            style = TextStyle(
                                color = Theme.colors.neutralWhite,
                                lineHeight = 24.sp,
                                fontSize = 16.sp,
                                fontFamily = Poppins,
                                fontWeight = FontWeight.Light
                            ),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            modifier = Modifier
                                .size(12.dp)
                                .rotate(180f),
                            painter = painterResource(R.drawable.top_rate),
                            colorFilter = ColorFilter.tint(Color.White),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                    if (open) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Spacer(
                            modifier = Modifier
                                .width(100.dp)
                                .padding(horizontal = 15.dp)
                                .height(1.dp)
                                .background(Theme.colors.pairColor)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        LazyColumn {
                            items(
                                items = persistentListOf(
                                    Pair("en", "English"),
                                    Pair("ru", "Russian"),
                                    Pair("ru", "Ukrainian"),
                                    Pair("ru", "Belarus"),
                                    Pair("ru", "Kazakhstan"),
                                ),
                                key = {
                                    it
                                }
                            ) {
                                Text(
                                    modifier = Modifier
                                        .bounceClick(from = .98f)
                                        .noRippleClickable {
                                            eventHandler.invoke(TradingEvent.SelectedLocale(it.second, it.first))
                                            onDismissRequest()
                                        },
                                    text = it.second,
                                    textAlign = TextAlign.End,
                                    style = TextStyle(
                                        color = Theme.colors.neutralWhite,
                                        lineHeight = 24.sp,
                                        fontSize = 16.sp,
                                        fontFamily = Poppins,
                                        fontWeight = FontWeight.Light
                                    ),
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .bounceClick(from = .98f)
                        .background(
                            Theme.colors.neutralBlack,
                            RoundedCornerShape(10.dp)
                        )
                        .border(1.dp, Theme.colors.pairColor, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 7.dp)
                        .noRippleClickable {
                            eventHandler.invoke(TradingEvent.ContactClick)
                            onDismissRequest()
                        },
                    text = stringResource(R.string.contact_us),
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .bounceClick(from = .98f)
                        .background(
                            Theme.colors.greenDark,
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 7.dp)
                        .noRippleClickable {
                            eventHandler.invoke(TradingEvent.CloseAppClick)
                        },
                    text = stringResource(R.string.exit_app),
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}