package com.example.stormy.navigation

enum class AppScreen {
    Home;

    companion object {
        fun fromRoute(route: String?): AppScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                null -> Home
                else -> throw IllegalArgumentException("Route $route not recognized")
            }
    }
}