package com.kotdev.trading.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import com.kotdev.trading.navigation.generateGraph

@Composable
fun setupNavigation(
    activity: Activity
) {
    generateGraph(activity)
}