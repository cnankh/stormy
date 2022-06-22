package com.example.stormy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stormy.feature.forecast.model.ForecastRoutes
import com.example.stormy.feature.forecast.ui.ForecastBody

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ForecastRoutes.local().route
    ) {
        composable(ForecastRoutes.local().route) {
            ForecastBody()
        }
    }
}