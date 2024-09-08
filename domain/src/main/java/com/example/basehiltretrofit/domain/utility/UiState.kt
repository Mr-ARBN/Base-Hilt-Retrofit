package com.example.basehiltretrofit.domain.utility

sealed class UiState<out R> {
    data object Loading : UiState<Nothing>()
    data object Idle : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val errorMessage: String) : UiState<Nothing>()
}
