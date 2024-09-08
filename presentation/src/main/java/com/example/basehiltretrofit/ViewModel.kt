package com.example.basehiltretrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basehiltretrofit.domain.model.remote.TestRequest
import com.example.basehiltretrofit.domain.model.remote.TestResponse
import com.example.basehiltretrofit.domain.use_case.TestUseCase
import com.example.basehiltretrofit.domain.utility.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val testUseCase: TestUseCase) : ViewModel() {
    private val _state = MutableStateFlow<UiState<TestResponse>>(UiState.Idle)
    val state: StateFlow<UiState<TestResponse>> = _state.asStateFlow()

    fun getDataRemote() {
        viewModelScope.launch {
            testUseCase.testApi(
                testRequest = TestRequest(
                    name = "Apple MacBook Pro 16",
                    year = 2019,
                    price = 1849.99,
                    cPUModel = "Intel Core i9",
                    hardDiskSize = "1 TB"
                )
            )
                .onEach { _state.value = it }
                .launchIn(viewModelScope)
        }
    }
}