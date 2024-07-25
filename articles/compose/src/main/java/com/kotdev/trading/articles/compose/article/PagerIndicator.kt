package com.kotdev.trading.articles.compose.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun PagerIndicator(
    pageCount: Int,
    currentPage: Int
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        repeat(pageCount) { iteration ->
            val color =
                if (currentPage == iteration) Color(0xFF22DBBB) else Color(
                    0xFF323234
                )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .weight(1f)
                    .background(color, RoundedCornerShape(10.dp))
            )
        }
    }
}