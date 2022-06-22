package com.example.stormy.feature.current.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentResponse(
    val location: Location = Location(),
    val current: Current = Current(),

    @SerialName("wind_kph")
    val wind: String = "",

    val humidity: String = "",

    @SerialName("feels_like")
    val feelsLike: String = "",
)

@Serializable
data class Location(
    val name: String = "",
    val region: String = "",
    val country: String = "",
)

@Serializable
data class Current(
    @SerialName("last_updated")
    val lastUpdated: String = "",

    @SerialName("temp_c")
    val tempC: String = "",

    @SerialName("temp_f")
    val temF: String = "",

    @SerialName("is_day")
    val isDay: Int = 0,

    val condition: Condition = Condition(),
)

@Serializable
data class Condition(
    val text: String = "",
    val icon: String = "",
    val code: String = "",
)