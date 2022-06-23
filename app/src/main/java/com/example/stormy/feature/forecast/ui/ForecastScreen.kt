package com.example.stormy.feature.forecast.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stormy.core.components.DayColumn
import com.example.stormy.core.components.HourRow
import com.example.stormy.core.components.Now
import com.example.stormy.core.model.ServiceState
import com.example.stormy.feature.forecast.model.Current
import com.example.stormy.feature.forecast.model.ForecastDay
import com.example.stormy.feature.forecast.model.ForecastParams
import com.example.stormy.feature.forecast.model.ForecastResponse

@Composable
fun ForecastBody(
    modifier: Modifier = Modifier,
    forecastViewModel: ForecastViewModel = hiltViewModel(),
    status: ServiceState = forecastViewModel.forecastState.value.status,
    response: ForecastResponse? = forecastViewModel.forecastState.value.content,
    current: Current? = response?.current,
    forecastDay: List<ForecastDay>? = response?.forecast?.forecastDay
) {
    forecastViewModel.getForecast(ForecastParams(q = "London"))

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp), verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
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
                DayColumn(content = forecastDay)
            }

            ServiceState.Error -> {
                Text(text = "Error")
            }
        }
    }

}