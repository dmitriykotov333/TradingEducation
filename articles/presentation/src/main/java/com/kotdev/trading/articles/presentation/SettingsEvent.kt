package com.kotdev.trading.articles.presentation

sealed class SettingsEvent {

   data object BackClick: SettingsEvent()
   data class ItemClick(val index: Int): SettingsEvent()
}