package com.example.stormy.feature.current.ui

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stormy.core.model.ServiceState
import com.example.stormy.feature.current.model.CurrentParams

@Composable
fun CurrentBody(
    currentViewModel: CurrentViewModel = hiltViewModel(),
    status: ServiceState = currentViewModel.currentState.value.status,
) {
    currentViewModel.getCurrent(CurrentParams(q = "London"))

    when (status) {
        ServiceState.Loading -> {
            Text(text = "Loading")
        }

        ServiceState.Success -> {
            Text(text = "Success")
            Log.d("currentScreen", "is : ${currentViewModel.currentState.value.content}")
        }

        ServiceState.Error -> {
            Text(text = "Error")
        }
    }

}