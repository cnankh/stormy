package com.example.stormy.feature.forecast.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stormy.core.components.HourRow
import com.example.stormy.core.components.Now
import com.example.stormy.core.model.ServiceState
import com.example.stormy.feature.forecast.model.Current
import com.example.stormy.feature.forecast.model.ForecastDay
import com.example.stormy.feature.forecast.model.ForecastParams
import com.example.stormy.feature.forecast.model.ForecastResponse

@Composable
fun ForecastBody(
    forecastViewModel: ForecastViewModel = hiltViewModel(),
    status: ServiceState = forecastViewModel.forecastState.value.status,
    response: ForecastResponse? = forecastViewModel.forecastState.value.content,
    current: Current? = response?.current,
    forecastDay: List<ForecastDay>? = response?.forecast?.forecastDay
) {
    forecastViewModel.getForecast(ForecastParams(q = "London"))

    Column {
        when (status) {
            ServiceState.Loading -> {
                Text(text = "Loading")
            }

            ServiceState.Success -> {
                Now(
                    temperature = "${current!!.tempC.toInt()}",
                    feeling = response!!.feelsLike,
                    wind = response.wind,
                    humidity = response.humidity
                )
                HourRow(content = forecastDay!![0].hour)
            }

            ServiceState.Error -> {
                Text(text = "Error")
            }
        }
    }

}