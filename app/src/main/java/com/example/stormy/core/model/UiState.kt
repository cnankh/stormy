package com.example.stormy.core.model

data class UiState<out T>(
    val status: ServiceState,
    val content: T? = null,
    val message: String = ""
) {
    companion object {
        fun <T> loading(): UiState<T> = UiState(status = ServiceState.Loading)

        fun <T> success(content: T, message: String = ""): UiState<T> =
            UiState(status = ServiceState.Success, content = content, message = message)

        fun <T> error(message: String): UiState<T> =
            UiState(status = ServiceState.Error, message = message)
    }
}

enum class ServiceState {
    Loading,
    Success,
    Error
}