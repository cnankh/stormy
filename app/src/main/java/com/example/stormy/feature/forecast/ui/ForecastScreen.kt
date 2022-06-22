package com.example.stormy.feature.forecast.ui

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stormy.core.model.ServiceState
import com.example.stormy.feature.forecast.model.ForecastParams

@Composable
fun ForecastBody(
    forecastViewModel: ForecastViewModel = hiltViewModel(),
    status: ServiceState = forecastViewModel.forecastState.value.status,
) {
    forecastViewModel.getForecast(ForecastParams(q = "London"))

    when (status) {
        ServiceState.Loading -> {
            Text(text = "Loading")
        }

        ServiceState.Success -> {
            Text(text = "Success")
            Log.d("currentScreen", "is : ${forecastViewModel.forecastState.value.content}")
        }

        ServiceState.Error -> {
            Text(text = "Error")
        }
    }

}