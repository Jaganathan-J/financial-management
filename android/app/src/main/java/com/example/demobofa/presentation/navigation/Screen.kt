package com.example.demobofa.presentation.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object MainContainer : Screen("main_container")
    data object Menu : Screen("menu")
}