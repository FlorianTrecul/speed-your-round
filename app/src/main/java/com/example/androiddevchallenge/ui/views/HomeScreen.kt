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

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRow
import androidx.compose.material.Tab
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.CategoryFactory.categoriesList
import com.example.androiddevchallenge.data.PositionFactory.positionsList
import com.example.androiddevchallenge.model.StockPosition
import com.example.androiddevchallenge.ui.components.CategoryChip
import com.example.androiddevchallenge.ui.components.StockPositionsList
import com.example.androiddevchallenge.ui.components.WeTradeButton
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.views.HomeTabs.Account
import java.util.*

private enum class HomeTabs(
    @StringRes val titleRes: Int,
) {
    Account(R.string.home_account_tab),
    Watchlist(R.string.home_watchlist_tab),
    Profile(R.string.home_profile_tab),
}

@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    val (selectedTab) = remember { mutableStateOf(Account) }
    val tabs = HomeTabs.values()

    Surface(color = MaterialTheme.colors.background) {
        PositionsBottomSheet(positionsList) {
            Column {
                TabRow(
                    selectedTabIndex = selectedTab.ordinal,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    backgroundColor = Color.Transparent,
                    indicator = { },
                    divider = { }
                ) {
                    tabs.forEachIndexed { index, tab ->
                        val isSelected = index == selectedTab.titleRes
                        Tab(
                            selected = isSelected,
                            selectedContentColor = MaterialTheme.colors.onBackground,
                            unselectedContentColor = MaterialTheme.colors.onBackground.copy(
                                alpha = ContentAlpha.disabled
                            ),
                            onClick = { }
                        ) {
                            val tabName = stringResource(id = tab.titleRes)
                            Text(
                                text = tabName.toUpperCase(Locale.getDefault()),
                                modifier = Modifier.paddingFromBaseline(top = 64.dp, bottom = 8.dp),
                                style = MaterialTheme.typography.button,
                                color = MaterialTheme.colors.onBackground
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeResume()
            }
        }
    }
}

@Composable
fun HomeResume() {
    Text(
        text = "Balance",
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(8.dp),
        style = MaterialTheme.typography.subtitle1,
        color = Color.White,
        textAlign = TextAlign.Center
    )
    Text(
        text = "$73,589.01",
        modifier = Modifier
            .paddingFromBaseline(48.dp)
            .padding(8.dp),
        style = MaterialTheme.typography.h1,
        color = Color.White,
        textAlign = TextAlign.Center
    )
    Text(
        text = "+412.35 today",
        modifier = Modifier
            .paddingFromBaseline(16.dp)
            .padding(24.dp),
        style = MaterialTheme.typography.subtitle1,
        color = green,
        textAlign = TextAlign.Center
    )
    WeTradeButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth(0.9f),
    ) {
        Text(
            text = stringResource(R.string.home_transact).toUpperCase(Locale.getDefault())
        )
    }
    CategoryChip(categories = categoriesList)
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
        painter = painterResource(id = R.drawable.home_illos),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@ExperimentalMaterialApi
@Composable
fun PositionsBottomSheet(
    positions: List<StockPosition>,
    content: @Composable (PaddingValues) -> Unit
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(0.dp),
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.home_position_bottom_sheet),
                    modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 24.dp),
                    style = typography.subtitle1
                )
                StockPositionsList(positions)
            }
        },
        sheetPeekHeight = 64.dp,
        content = content
    )
}
