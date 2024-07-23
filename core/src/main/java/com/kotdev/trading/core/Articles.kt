package com.kotdev.trading.core

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class Articles(
    val title: Int,
    val description: Int?,
    val background: Int,
    val color: Color,
    val detail: ImmutableList<ArticleDetail>
)

@Immutable
data class ArticleDetail(
    val title: Int,
    val description: Int,
    val background: Int,
)