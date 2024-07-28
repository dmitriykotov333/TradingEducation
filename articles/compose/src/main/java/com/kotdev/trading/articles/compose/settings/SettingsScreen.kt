package com.kotdev.trading.articles.compose.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.kotdev.trading.articles.presentation.SettingsEvent
import com.kotdev.trading.articles.presentation.SettingsViewModel
import com.kotdev.trading.core.Articles
import com.kotdev.trading.core_ui.component.HeaderContent

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel
) {
    val state by viewModel.states().collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderContent {
            viewModel.obtainEvent(SettingsEvent.BackClick)
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(
                top = 15.dp, bottom = 90.dp, start = 15.dp, end = 15.dp
            ), verticalArrangement = Arrangement.spacedBy(
                15.dp
            )
        ) {
            itemsIndexed(
                items = state.items,
                key = { index, item ->
                    item.title
                },
                itemContent = { index, item ->
                    Article(item) {
                        viewModel.obtainEvent(SettingsEvent.ItemClick(index))
                    }
                }
            )
        }
    }
}









