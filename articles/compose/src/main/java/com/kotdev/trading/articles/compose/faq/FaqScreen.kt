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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotdev.trading.articles.presentation.SettingsEvent
import com.kotdev.trading.articles.presentation.SettingsViewModel
import com.kotdev.trading.core.FaqItem
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme

@Composable
fun FaqScreen(
    viewModel: SettingsViewModel = viewModel()
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






