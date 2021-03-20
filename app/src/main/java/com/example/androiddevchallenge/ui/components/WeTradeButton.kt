package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate

@Composable
fun WeTradeButton(
    onClick: () -> Unit,
    modifier: Modifier,
    isSecondary: Boolean = false,
    content: @Composable RowScope.() -> Unit
) {
    if (!isSecondary) {
        Button(
            onClick = onClick,
            modifier = modifier
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            ),
            shape = RoundedCornerShape(50),
            content = content
        )
    } else {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier
                .height(48.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.primary),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colors.primary,
                backgroundColor = Color.Transparent
            ),
            shape = RoundedCornerShape(50),
            content = content
        )
    }
}