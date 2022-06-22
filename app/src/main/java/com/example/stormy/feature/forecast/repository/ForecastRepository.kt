package com.example.stormy.feature.forecast.repository

import com.example.stormy.feature.forecast.model.ForecastParams
import com.example.stormy.feature.forecast.model.ForecastResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ForecastRepository @Inject constructor(private val dataSource: ForecastRemoteDataSource) {
    suspend fun getForecast(forecastParams: ForecastParams): Flow<ForecastResponse> =
        dataSource.getCurrent(forecastParams = forecastParams)
}