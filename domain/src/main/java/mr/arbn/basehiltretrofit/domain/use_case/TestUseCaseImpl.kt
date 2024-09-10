package mr.arbn.basehiltretrofit.domain.use_case


import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteRequestEntity
import mr.arbn.basehiltretrofit.data.source.local.TestRoomUserDao
import mr.arbn.basehiltretrofit.data.source.remote.repository.TestRemoteRepo
import mr.arbn.basehiltretrofit.data.utility.Result
import mr.arbn.basehiltretrofit.domain.model.remote.TestRequest
import mr.arbn.basehiltretrofit.domain.model.remote.TestResponse
import mr.arbn.basehiltretrofit.domain.utility.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class TestUseCaseImpl @Inject constructor(
    private val testRoomUserDao: TestRoomUserDao,
    private val testRemoteRepo: TestRemoteRepo
) : TestUseCase {
    override suspend fun testApi(testRequest: TestRequest): Flow<UiState<TestResponse>> = flow {
        emit(UiState.Loading)
        val request = TestRemoteRequestEntity(
            name = testRequest.name,
            data = TestRemoteRequestEntity.TestDataRequestEntity(
                cpuModel = testRequest.data.cpuModel,
                year = testRequest.data.year,
                price = testRequest.data.price,
                hardDiskSize = testRequest.data.hardDiskSize
            )
        )
        val readDatabase = testRoomUserDao.getAllUsers()
        val response = testRemoteRepo.testApi(request)
        when {
            response is Result.Success && response.data.data != null -> TestResponse(
                createdAt = response.data.createdAt,
                name = response.data.name,
                data = TestResponse.Data(
                    year = response.data.data!!.year,
                    price = response.data.data!!.price,
                    hardDiskSize = response.data.data!!.hardDiskSize,
                    cpuModel = response.data.data!!.cpuModel
                ),
                id = response.data.id,
            ).also { emit(UiState.Success(it)) }

            else -> emit(UiState.Error("There Is Something Wrong"))
        }
    }
}