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
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kotdev.trading.articles.presentation.SettingsEvent
import com.kotdev.trading.articles.presentation.SettingsViewModel
import com.kotdev.trading.core.Articles
import com.kotdev.trading.core_ui.component.HeaderContent
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme

@Composable
internal fun Article(
    item: Articles,
    onClick: () -> Unit
) {
    Box(
        Modifier
            .bounceClick(from = 0.95f)
            .fillMaxWidth()
            .height(93.dp)
            .background(
                color = item.color, RoundedCornerShape(10.dp)
            ).noRippleClickable {
                onClick()
            },
    ) {
        AsyncImage(
            modifier = Modifier.align(Alignment.CenterEnd).height(95.dp).padding(end = 1.dp),
            model = item.background,
            contentDescription = item.background.toString(),
            contentScale = ContentScale.Fit,
        )
        Column(
            modifier = Modifier.align(Alignment.CenterStart).padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                modifier = Modifier,
                text = stringResource(item.title),
                style = TextStyle(
                    color = Theme.colors.neutralWhite,
                    lineHeight = 27.sp,
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold
                ),
            )
            if (item.description != null) {
                Text(
                    modifier = Modifier,
                    text = stringResource(item.description!!),
                    style = TextStyle(
                        color = Theme.colors.neutralWhite,
                        lineHeight = 18.sp,
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
        }

    }
}
