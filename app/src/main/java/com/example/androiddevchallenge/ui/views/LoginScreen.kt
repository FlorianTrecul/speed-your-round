package com.example.androiddevchallenge.ui.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.hideSystemUi
import com.example.androiddevchallenge.ui.components.setStatusBarTransparent

@Composable
fun LoginScreen(navController: NavController) {
    val window = (LocalContext.current as Activity).window
    setStatusBarTransparent(window = window)
    hideSystemUi(window = window)

    var email: String by mutableStateOf("")
    var password: String by mutableStateOf("")

    Surface(color = MaterialTheme.colors.secondary) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.login_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    modifier = Modifier
                        .paddingFromBaseline(152.dp)
                        .fillMaxWidth(),
                    text = "Welcome\nback",
                    style = MaterialTheme.typography.h2,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        text = "Email address",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, end = 16.dp, start = 16.dp)
                    .height(56.dp),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "Email Icon",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                },
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Password",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, end = 16.dp, start = 16.dp)
                    .height(56.dp),
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Password,
                        contentDescription = "Password Icon",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                },
            )
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(top = 16.dp, end = 16.dp, start = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}