package com.example.stormy.feature.forecast.repository

import android.util.Log
import com.example.stormy.core.convertTime
import com.example.stormy.core.module.IoDispatcher
import com.example.stormy.feature.forecast.model.ForecastParams
import com.example.stormy.feature.forecast.model.ForecastResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import okhttp3.Response
import javax.inject.Inject

class ForecastRepository @Inject constructor(
    @IoDispatcher val dispatcher: CoroutineDispatcher,
    private val dataSource: ForecastRemoteDataSource
) {
    suspend fun getForecast(forecastParams: ForecastParams): Flow<ForecastResponse> = flow {
        var response: ForecastResponse = ForecastResponse()
        dataSource.getCurrent(forecastParams).collect {
            response = it
        }

        extractTime(response)

        emit(response)

    }.flowOn(dispatcher)

    /**
     * split the exact time from the date
     * @param response
     */
    private fun extractTime(response: ForecastResponse) {
        val hours = response.forecast.forecastDay[0].hour

        for (hour in hours) {
            val formattedTime = convertTime(hour.time)
            hour.time = formattedTime
        }
    }
}