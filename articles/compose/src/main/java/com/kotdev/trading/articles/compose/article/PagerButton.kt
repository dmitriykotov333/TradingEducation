package com.kotdev.trading.articles.compose.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotdev.trading.core_ui.modifiers.bounceClick
import com.kotdev.trading.core_ui.modifiers.noRippleClickable
import com.kotdev.trading.core_ui.theme.Poppins
import com.kotdev.trading.core_ui.theme.Theme
import kotlinx.coroutines.launch

@Composable
internal fun ColumnScope.PagerButton(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .bounceClick(from = .91f)
            .background(
                Theme.colors.greenDark,
                RoundedCornerShape(10.dp)
            ).noRippleClickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 50.dp, vertical = 5.dp),
            text = stringResource(com.kotdev.trading.core_ui.R.string.next),
            style = TextStyle(
                color = Theme.colors.neutralWhite,
                lineHeight = 24.sp,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal
            ),
        )
    }
}