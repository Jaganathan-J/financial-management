package com.example.demobofa.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demobofa.presentation.splash.SplashScreen
import com.example.demobofa.presentation.login.LoginScreen
import com.example.demobofa.presentation.main.MainContainerScreen
import com.example.demobofa.presentation.menu.MenuScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.MainContainer.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.MainContainer.route) {
            MainContainerScreen(
                onMenuClick = { navController.navigate(Screen.Menu.route) },
                onLogOut = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.MainContainer.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Menu.route) {
             MenuScreen(
                 onBack = { navController.popBackStack() }
             )
        }
    }
}