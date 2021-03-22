/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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