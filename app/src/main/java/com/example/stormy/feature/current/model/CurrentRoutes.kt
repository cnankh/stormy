package com.example.stormy.feature.current.model

import com.example.stormy.navigation.AppScreen

data class CurrentRoutes(val route: String) {
    companion object {
        fun remote(): CurrentRoutes = CurrentRoutes("current.json")

        fun local(): CurrentRoutes =
            CurrentRoutes(AppScreen.Current.name)

        fun graph(): CurrentRoutes =
            CurrentRoutes("")

    }
}