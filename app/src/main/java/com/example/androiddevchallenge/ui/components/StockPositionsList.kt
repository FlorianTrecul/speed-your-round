package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
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
            Modifier
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
