package com.example.stormy.feature.forecast.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.stormy.core.base.BaseViewModel
import com.example.stormy.core.module.IoDispatcher
import com.example.stormy.core.model.UiState
import com.example.stormy.feature.forecast.model.ForecastParams
import com.example.stormy.feature.forecast.model.ForecastResponse
import com.example.stormy.feature.forecast.repository.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    @IoDispatcher override val dispatcher: CoroutineDispatcher,
    private val repository: ForecastRepository
) : BaseViewModel(dispatcher) {

    private var _forecastState: MutableState<UiState<ForecastResponse>> =
        mutableStateOf(UiState.loading())
    val forecastState: MutableState<UiState<ForecastResponse>>
        get() = _forecastState


    /**
     * @param forecastParams
     */
    fun getForecast(forecastParams: ForecastParams) {
        viewModelScope.launch(dispatcher) {
            repository.getForecast(forecastParams = forecastParams)
                .catch { it ->
                    _forecastState.value = UiState.error(it.message.toString())
                }
                .collect {
                    _forecastState.value = UiState.success(it)
                }
        }
    }

}