package com.example.stormy.feature.current.model

import kotlinx.serialization.Serializable

/**
 * q: Pass US Zipcode, UK Postcode, Canada PostalCode, IP address, Latitude/Longitude (decimal degree) or city name
 * days: Number of days of weather forecast. Value ranges from 1 to 10
 */
@Serializable
data class CurrentParams(
    val q: String = "",
    val days: Int = 7
)