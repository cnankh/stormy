package com.example.stormy.navigation

enum class AppScreen {
    Forecast;

    companion object {
        fun fromRoute(route: String?): AppScreen =
            when (route?.substringBefore("/")) {
                Forecast.name -> Forecast
                null -> Forecast
                else -> throw IllegalArgumentException("Route $route not recognized")
            }
    }
}