package com.kotdev.trading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.AsyncImage
import com.kotdev.trading.core_ui.theme.TradingEducationTheme
import com.kotdev.trading.core.helpers.LocaleHelper
import com.kotdev.trading.navigation.GenerateGraph
import com.kotdev.trading.viewModel.MainAction
import com.kotdev.trading.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        setContent {
            LaunchedEffect(Unit) {
                viewModel.actions().collectLatest {
                    when (it) {
                        is MainAction.Recreate -> {
                            if (resources.configuration.locale.country.lowercase() != it.locale) {
                                LocaleHelper.setLocale(this@MainActivity, it.locale)
                            }
                        }
                    }
                }
            }
            TradingEducationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box {
                        AsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            model = R.drawable.background,
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                        )
                        GenerateGraph(this@MainActivity)
                    }
                }
            }
        }
    }
}
