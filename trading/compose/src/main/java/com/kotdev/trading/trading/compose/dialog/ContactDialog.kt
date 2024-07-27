package com.kotdev.trading.trading.compose.dialog

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Background
import com.kotdev.trading.core_ui.theme.PairColor
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.trading.compose.snackbar.ContactSnackbar
import com.kotdev.trading.trading.presentation.contact.ContactAction
import com.kotdev.trading.trading.presentation.contact.ContactEvent
import com.kotdev.trading.trading.presentation.contact.ContactViewModel

import kotlinx.coroutines.flow.collectLatest

@SuppressLint("ProduceStateDoesNotAssignValue", "UnrememberedAnimatable")

@Composable
fun ContactDialog(
    viewModel: ContactViewModel = viewModel(),
    setShowDialog: (Boolean) -> Unit,
) {
    val states by viewModel.states().collectAsState()

    val isError by remember {
        derivedStateOf {
            states.error.isNotEmpty()
        }
    }

    ContactActionDialog(viewModel, close = {
        setShowDialog(false)
    })
    Dialog(
        onDismissRequest = {
            setShowDialog(false)
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false,
        )
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
                .padding(top = 15.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .graphicsLayer {
                        scaleX = scale.value
                        scaleY = scale.value
                    }
                    .drawWithCache {
                        this.onDrawBehind {
                            drawRoundRect(
                                color = PairColor,
                                size = size,
                                topLeft = Offset(0f, 0f),
                                style = Stroke(width = 1.dp.toPx()),
                                cornerRadius = CornerRadius(
                                    x = 10.dp.toPx(),
                                    y = 10.dp.toPx()
                                ),
                            )
                            drawRoundRect(
                                color = Background,
                                cornerRadius = CornerRadius(
                                    x = 10.dp.toPx(),
                                    y = 10.dp.toPx()
                                ),
                            )
                        }
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        text = stringResource(R.string.first_name),
                        style = TextStyle(
                            color = Theme.colors.pairColor,
                            lineHeight = 18.sp,
                            fontSize = 12.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Light
                        ),
                    )
                    IconButton(onClick = {
                        viewModel.obtainEvent(ContactEvent.CloseClick)
                    }) {
                        Image(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(R.drawable.close), contentDescription = null
                        )
                    }
                }
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .border(
                            BorderStroke(1.dp, Theme.colors.pairColor), RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp),
                    value = states.firstName,
                    onValueChange = {
                        viewModel.obtainEvent(ContactEvent.ChangeFirstName(it))
                    },
                    textStyle = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 21.sp,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        innerTextField()
                    },
                    cursorBrush = SolidColor(Theme.colors.pairColor),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp),
                    text = stringResource(R.string.last_name),
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 18.sp,
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(5.dp))
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .border(
                            BorderStroke(1.dp, Theme.colors.pairColor), RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp),
                    value = states.lastName,
                    singleLine = true,
                    onValueChange = {
                        viewModel.obtainEvent(ContactEvent.ChangeLastName(it))
                    },
                    textStyle = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 21.sp,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                    decorationBox = { innerTextField ->
                        innerTextField()
                    },
                    cursorBrush = SolidColor(Theme.colors.pairColor),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp),
                    text = stringResource(R.string.message),
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 18.sp,
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(5.dp))
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(horizontal = 15.dp)
                        .border(
                            BorderStroke(1.dp, Theme.colors.pairColor), RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp),
                    value = states.message,
                    onValueChange = {
                        viewModel.obtainEvent(ContactEvent.ChangeMessage(it))
                    },
                    textStyle = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 21.sp,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                    decorationBox = { innerTextField ->
                        innerTextField()
                    },
                    cursorBrush = SolidColor(Theme.colors.pairColor),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    modifier = Modifier
                        .bounceClick(from = .98f)
                        .background(
                            Theme.colors.greenDark,
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 21.dp, vertical = 7.dp)
                        .noRippleClickable {
                            viewModel.obtainEvent(ContactEvent.SendClick)
                        },
                    text = stringResource(R.string.send),
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 24.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
    if (isError) {
        ContactSnackbar(states.error)
    }
}

@Composable
fun ContactActionDialog(viewModel: ContactViewModel, close: () -> Unit) {
    LaunchedEffect(Unit) {
        viewModel.actions().collectLatest {
            when (it) {
                is ContactAction.Close -> {
                    close()
                }
            }
        }
    }
}