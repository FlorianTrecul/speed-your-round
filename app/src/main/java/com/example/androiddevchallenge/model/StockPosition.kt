package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class StockPosition(
    val code: String,
    val name: String,
    val amountInDollar: Float,
    val progressPercentage: Float,
    @DrawableRes val graphImage: Int
)
