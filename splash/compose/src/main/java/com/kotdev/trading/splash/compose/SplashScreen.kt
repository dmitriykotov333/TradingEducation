package com.kotdev.trading.splash.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import com.kotdev.trading.splash.presentation.SplashViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel()
) {
    val state by viewModel.states().collectAsState()

    val isError by remember {
        derivedStateOf {
            state.error.isNotEmpty()
        }
    }

    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = isError)
    {
       if (isError) {
           snackbarHostState.showSnackbar(state.error)
       }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()

        SnackbarHost(hostState = snackbarHostState) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            )
            {
                Text(
                    modifier = Modifier
                        .padding(30.dp)
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .background(Theme.colors.red, RoundedCornerShape(10.dp))
                        .padding(10.dp)
                        .align(Alignment.BottomCenter),
                    text = state.error,
                    style = TextStyle(
                        color = Color.White,
                        lineHeight = 23.sp,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
        }
    }
}






