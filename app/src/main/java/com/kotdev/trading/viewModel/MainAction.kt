package com.kotdev.trading.viewModel

sealed class MainAction {
    data class Recreate(val locale: String) : MainAction()
}