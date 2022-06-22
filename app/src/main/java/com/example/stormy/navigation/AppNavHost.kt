package com.example.stormy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stormy.feature.current.model.CurrentRoutes
import com.example.stormy.feature.current.ui.CurrentBody

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CurrentRoutes.local().route
    ) {
        composable(CurrentRoutes.local().route) {
            CurrentBody()
        }
    }
}