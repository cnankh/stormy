package com.example.stormy.feature.current.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.stormy.core.base.BaseViewModel
import com.example.stormy.core.di.IoDispatcher
import com.example.stormy.core.model.UiState
import com.example.stormy.feature.current.model.CurrentParams
import com.example.stormy.feature.current.model.CurrentResponse
import com.example.stormy.feature.current.repository.CurrentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentViewModel @Inject constructor(
    @IoDispatcher override val dispatcher: CoroutineDispatcher,
    private val repository: CurrentRepository
) : BaseViewModel(dispatcher) {

    private var _currentState: MutableState<UiState<CurrentResponse>> =
        mutableStateOf(UiState.loading())
    val currentState: MutableState<UiState<CurrentResponse>>
        get() = _currentState


    /**
     * @param currentParams
     */
    fun getCurrent(currentParams: CurrentParams) {
        viewModelScope.launch(dispatcher) {
            repository.getCurrent(currentParams = currentParams)
                .catch { it ->
                    _currentState.value = UiState.error(it.message.toString())
                }
                .collect {
                    _currentState.value = UiState.success(it)
                }
        }
    }

}