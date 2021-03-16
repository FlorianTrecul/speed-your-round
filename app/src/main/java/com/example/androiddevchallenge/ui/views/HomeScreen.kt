package com.example.androiddevchallenge.ui.views

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.androiddevchallenge.ui.components.hideSystemUi
import com.example.androiddevchallenge.ui.components.setStatusBarTransparent

@Composable
fun HomeScreen() {
    val window = (LocalContext.current as Activity).window
    setStatusBarTransparent(window = window)
    hideSystemUi(window = window)
}