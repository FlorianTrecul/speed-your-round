package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.views.HomeScreen
import com.example.androiddevchallenge.ui.views.LoginScreen
import com.example.androiddevchallenge.ui.views.WelcomeScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "weTradeHome") {
        composable("weTradeHome") {
            WelcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            HomeScreen()
        }
    }
}