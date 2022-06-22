package com.example.stormy.feature.forecast.repository

import com.example.stormy.core.base.BaseRemoteDataSource
import com.example.stormy.core.module.IoDispatcher
import com.example.stormy.feature.forecast.model.ForecastParams
import com.example.stormy.feature.forecast.model.ForecastResponse
import com.example.stormy.feature.forecast.model.ForecastRoutes
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ForecastRemoteDataSource @Inject constructor(@IoDispatcher val dispatcher: CoroutineDispatcher) :
    BaseRemoteDataSource() {

    /**
     * Pass US Zipcode, UK Postcode, Canada PostalCode, IP address, Latitude/Longitude (decimal degree) or city name
     * @param forecastParams
     * @return Flow<CurrentResponse>
     */
    suspend fun getCurrent(forecastParams: ForecastParams): Flow<ForecastResponse> = flow {
        val endpoint = ForecastRoutes.remote().route
        val response: ForecastResponse = client.get {
            url(endpoint)

            parameter("key", api.key)
            parameter("q", forecastParams.q)
            parameter("days", forecastParams.days)

        }.body()

        emit(response)
    }.flowOn(dispatcher)
}