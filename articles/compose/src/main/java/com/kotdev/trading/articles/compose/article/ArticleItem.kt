package com.kotdev.trading.articles.compose.article

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kotdev.trading.core.ArticleDetail
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme

@Composable
internal fun ArticleItem(
    item: ArticleDetail
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    BorderStroke(1.dp, Color(0xFF3B3B3B)), RoundedCornerShape(10.dp)
                ),
            model = item.background,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(item.title),
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Theme.colors.pairColor,
                lineHeight = 26.sp,
                fontSize = 21.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier,
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