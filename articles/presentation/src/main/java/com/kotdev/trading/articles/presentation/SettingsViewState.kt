package com.kotdev.trading.articles.presentation

import androidx.compose.runtime.Immutable
import com.kotdev.trading.core.Articles
import com.kotdev.trading.core.FaqItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


@Immutable
data class SettingsViewState(
    val items: ImmutableList<Articles> = persistentListOf(),
    val faqs: ImmutableList<FaqItem> = persistentListOf()
)