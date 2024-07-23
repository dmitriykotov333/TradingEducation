package com.kotdev.trading.trading.compose.snackbar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core_ui.R
import com.kotdev.trading.core_ui.theme.Poppins

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactSnackbar(
    error: String
) {
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = Unit)
    {
        snackbarHostState.showSnackbar(error)
    }
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
                    .background(Color.Black, RoundedCornerShape(10.dp))
                    .graphicsLayer {
                        shadowElevation = 5f
                    }
                    .padding(10.dp)
                    .align(Alignment.BottomCenter),
                text = error,
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