package com.kotdev.trading.articles.compose.faq

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotdev.trading.articles.presentation.SettingsEvent
import com.kotdev.trading.articles.presentation.SettingsViewModel
import com.kotdev.trading.core.FaqItem
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme

@Composable
fun FaqScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state by viewModel.states().collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderFaqContent {
            viewModel.obtainEvent(SettingsEvent.BackClick)
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(
                top = 15.dp, bottom = 90.dp, start = 15.dp, end = 15.dp
            ), verticalArrangement = Arrangement.spacedBy(
                15.dp
            )
        ) {
            items(
                items = state.faqs,
                key = {
                    it.title
                },
                itemContent = {
                    FaqItem(it)
                }
            )
        }
    }
}


@Composable
internal fun FaqItem(
    item: FaqItem
) {
    var visible by remember {
        mutableStateOf(false)
    }
    Row(
        Modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF121212), Color(0xFF121212), Color(0xFF2C2C2C)
                    )
                ), RoundedCornerShape(10.dp)
            )
            .border(BorderStroke(1.dp, Theme.colors.neutralBlack), RoundedCornerShape(10.dp))
            .fillMaxWidth(),
        verticalAlignment = if (visible) Alignment.Top else Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(15.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(item.title),
                style = TextStyle(
                    color = Theme.colors.pairColor,
                    lineHeight = 26.sp,
                    fontSize = 17.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal
                ),
            )
            AnimatedVisibility(visible) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    text = stringResource(item.description),
                    style = TextStyle(
                        color = Theme.colors.pairColor,
                        lineHeight = 26.sp,
                        fontSize = 17.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal
                    ),
                )
            }
        }
        IconButton(onClick = {
            visible = !visible
        }) {
            Image(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .graphicsLayer {
                        rotationZ = if (visible) 180f else 0f
                    },
                painter = painterResource(com.kotdev.trading.core_ui.R.drawable.arrow_white),
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = null
            )
        }

    }
}







