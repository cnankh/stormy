package com.example.stormy.feature.home.ui

import com.example.stormy.core.base.BaseViewModel
import com.example.stormy.core.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @IoDispatcher override val dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher) {
}