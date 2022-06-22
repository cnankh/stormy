package com.example.stormy.feature.forecast.model

import com.example.stormy.navigation.AppScreen

data class ForecastRoutes(val route: String) {
    companion object {
        fun remote(): ForecastRoutes = ForecastRoutes("forecast.json")

        fun local(): ForecastRoutes =
            ForecastRoutes(AppScreen.Forecast.name)

        fun graph(): ForecastRoutes =
            ForecastRoutes("")

    }
}