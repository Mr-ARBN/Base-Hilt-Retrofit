package com.example.basehiltretrofit.domain.use_case


import com.example.basehiltretrofit.data.entity.remote.TestRequestEntity
import com.example.basehiltretrofit.data.source.local.TestUserDao
import com.example.basehiltretrofit.data.source.remote.repository.TestRepo
import com.example.basehiltretrofit.data.utility.Result
import com.example.basehiltretrofit.domain.model.remote.TestRequest
import com.example.basehiltretrofit.domain.model.remote.TestResponse
import com.example.basehiltretrofit.domain.utility.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class TestUseCaseImpl @Inject constructor(
    private val testUserDao: TestUserDao,
    private val testRepo: TestRepo
) : TestUseCase {
    override suspend fun testApi(testRequest: TestRequest): Flow<UiState<TestResponse>> = flow {
        emit(UiState.Loading)
        val request = TestRequestEntity(
            cPUModel = testRequest.cPUModel,
            name = testRequest.name,
            year = testRequest.year,
            price = testRequest.price,
            hardDiskSize = testRequest.hardDiskSize
        )
        when (val response = testRepo.testApi(request)) {
            is Result.Error -> emit(UiState.Error("There Is Something Wrong"))
            is Result.Success -> TestResponse(
                createdAt = response.data.createdAt,
                name = response.data.name,
                data = when (response.data.data != null) {
                    true -> TestResponse.Data(
                        year = response.data.data!!.year,
                        price = response.data.data!!.price,
                        hardDiskSize = response.data.data!!.hardDiskSize,
                        cPUModel = response.data.data!!.cPUModel
                    )

                    false -> TestResponse.Data(
                        year = 1900,
                        price = 200.0,
                        hardDiskSize = "response.data.data.hardDiskSize",
                        cPUModel = "response.data.data.cPUModel"
                    )
                },
                id = response.data.id,
            ).also { emit(UiState.Success(it)) }
        }
    }
}