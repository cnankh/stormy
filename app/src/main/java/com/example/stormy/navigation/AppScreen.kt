package com.example.stormy.navigation

enum class AppScreen {
    Current;

    companion object {
        fun fromRoute(route: String?): AppScreen =
            when (route?.substringBefore("/")) {
                Current.name -> Current
                null -> Current
                else -> throw IllegalArgumentException("Route $route not recognized")
            }
    }
}