package com.example.stormy.feature.forecast.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    val location: Location = Location(),
    val current: Current = Current(),

    @SerialName("wind_kph")
    val wind: String = "",

    val humidity: String = "",

    @SerialName("feels_like")
    val feelsLike: String = "",

    val forecast: Forecast = Forecast()
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
    val tempC: Float = 0F,

    @SerialName("temp_f")
    val temF: Float = 0F,

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

@Serializable
data class Forecast(
    @SerialName("forecastday")
    val forecastDay: List<ForecastDay> = emptyList()
)

@Serializable
data class ForecastDay(
    val day: Day = Day(),
    val hour: List<Hour> = emptyList()
)

@Serializable
data class Day(
    @SerialName("maxtemp_c")
    val maxTempC: Float = 0F,

    @SerialName("mintemp_c")
    val minTempC: Float = 0F,

    @SerialName("daily_will_it_rain")
    val willRain: Int = 0,

    @SerialName("daily_chance_of_rain")
    val rainChance: String = "",

    @SerialName("daily_will_it_snow")
    val willSnow: Int = 0,

    @SerialName("daily_chance_of_snow")
    val snowChance: String = "",

    val condition: Condition = Condition(),
)

@Serializable
data class Hour(
    val time: String = "",

    @SerialName("temp_c")
    val tempC: Float = 0F,

    @SerialName("is_day")
    val isDay: Int = 0,

    val condition: Condition = Condition(),

    @SerialName("will_it_rain")
    val willRain: Int = 0,

    @SerialName("chance_of_rain")
    val rainChance: String = "",

    @SerialName("will_it_snow")
    val willSnow: Int = 0,

    @SerialName("chance_of_snow")
    val snowChance: String = "",
)