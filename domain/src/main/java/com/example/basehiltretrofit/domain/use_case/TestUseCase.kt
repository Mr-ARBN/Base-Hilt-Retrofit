package com.example.basehiltretrofit.domain.use_case

import com.example.basehiltretrofit.domain.model.remote.TestRequest
import com.example.basehiltretrofit.domain.model.remote.TestResponse
import com.example.basehiltretrofit.domain.utility.UiState
import kotlinx.coroutines.flow.Flow

interface TestUseCase {

    suspend fun testApi(testRequest: TestRequest): Flow<UiState<TestResponse>>
}