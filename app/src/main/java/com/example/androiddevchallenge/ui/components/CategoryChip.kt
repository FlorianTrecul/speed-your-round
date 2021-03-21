package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChip(categories: List<String>) {
    LazyRow(
        modifier = Modifier.padding(start = 8.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        )
    ) {
        itemsIndexed(categories) { index, category ->
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .height(40.dp)
                    .padding(end = 16.dp),
                shape = RoundedCornerShape(50),
                border = BorderStroke(
                    ButtonDefaults.OutlinedBorderSize,
                    MaterialTheme.colors.onBackground
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colors.onBackground,
                    backgroundColor = Color.Transparent
                ),
            ) {
                Category(category = category, isIconDisplayed = index == 0)
            }
        }
    }
}

@Composable
private fun Category(category: String, isIconDisplayed: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            category,
            style = MaterialTheme.typography.body1
        )
        if (isIconDisplayed) {
            Icon(
                Icons.Default.ExpandMore,
                "View more",
                Modifier
                    .padding(start = 8.dp)
                    .size(16.dp)
            )
        }
    }
}