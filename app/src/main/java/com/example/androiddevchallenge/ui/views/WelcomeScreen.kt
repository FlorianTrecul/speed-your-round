package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.example.androiddevchallenge.R.drawable.logo
import com.example.androiddevchallenge.R.drawable.welcome_bg
import com.example.androiddevchallenge.R.string.*
import com.example.androiddevchallenge.ui.components.WeTradeButton
import java.util.*

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Image(
                painterResource(logo),
                stringResource(app_name)
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
                    Text(stringResource(welcome_started).toUpperCase(Locale.getDefault()))
                }
                WeTradeButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),
                    isSecondary = true
                ) {
                    Text(stringResource(welcome_log_in).toUpperCase(Locale.getDefault()))
                }
            }
        }
    }
}