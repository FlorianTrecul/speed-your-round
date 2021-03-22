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

package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.WeTradeButton
import java.util.Locale

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.app_name)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
                    .align(alignment = Alignment.BottomCenter),
            ) {
                WeTradeButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp, start = 16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.welcome_started).toUpperCase(Locale.getDefault())
                    )
                }
                WeTradeButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),
                    isSecondary = true
                ) {
                    Text(
                        text = stringResource(R.string.welcome_log_in).toUpperCase(Locale.getDefault())
                    )
                }
            }
        }
    }
}