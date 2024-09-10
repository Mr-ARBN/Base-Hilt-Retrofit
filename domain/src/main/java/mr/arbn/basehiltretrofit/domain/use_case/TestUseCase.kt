package mr.arbn.basehiltretrofit.domain.use_case

import mr.arbn.basehiltretrofit.domain.model.remote.TestRequest
import mr.arbn.basehiltretrofit.domain.model.remote.TestResponse
import mr.arbn.basehiltretrofit.domain.utility.UiState
import kotlinx.coroutines.flow.Flow

interface TestUseCase {
    suspend fun testApi(testRequest: TestRequest): Flow<UiState<TestResponse>>
}