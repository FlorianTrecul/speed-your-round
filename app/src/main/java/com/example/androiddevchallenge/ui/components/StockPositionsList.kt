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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.StockPosition
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun StockPositionsList(positions: List<StockPosition>) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        items(positions) { position ->
            Divider(modifier = Modifier.height(1.5.dp))
            StockPositionItem(position)
        }
    }
}

@Composable
fun StockPositionItem(position: StockPosition) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.width(48.dp)) {
            Text(
                text = "${position.amountInDollar}",
                modifier = Modifier.paddingFromBaseline(top = 24.dp),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                text = if (position.progressPercentage < 0f) "${position.progressPercentage}%" else "+${position.progressPercentage}%",
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.body1,
                color = if (position.progressPercentage < 0f) red else green,
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = position.code,
                modifier = Modifier.paddingFromBaseline(top = 24.dp),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                text = position.name,
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
        }
        Image(
            painter = painterResource(position.graphImage),
            contentDescription = "Graph position image",
            contentScale = ContentScale.FillHeight
        )
    }
}
