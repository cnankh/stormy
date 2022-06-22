package com.example.stormy.feature.current.model

import kotlinx.serialization.Serializable

/**
 * q: Pass US Zipcode, UK Postcode, Canada PostalCode, IP address, Latitude/Longitude (decimal degree) or city name
 */
@Serializable
data class CurrentParams(
    val q: String = "",
)