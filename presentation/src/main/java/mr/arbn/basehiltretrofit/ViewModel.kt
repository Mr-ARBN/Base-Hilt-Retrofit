package mr.arbn.basehiltretrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import mr.arbn.basehiltretrofit.domain.model.remote.TestRequest
import mr.arbn.basehiltretrofit.domain.model.remote.TestResponse
import mr.arbn.basehiltretrofit.domain.use_case.TestUseCase
import mr.arbn.basehiltretrofit.domain.utility.UiState
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
                    name = "Asus",
                    data = TestRequest.Data(
                        year = 2024,
                        price = 2499.0,
                        cpuModel = "AMD Ryzen 9000",
                        hardDiskSize = "1 TB"
                    )
                )
            )
                .onEach { _state.value = it }
                .launchIn(viewModelScope)
        }
    }
}