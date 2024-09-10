package mr.arbn.basehiltretrofit.data.source.remote.repository

import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteRequestEntity
import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteResponseEntity
import mr.arbn.basehiltretrofit.data.source.remote.service.TestApi
import mr.arbn.basehiltretrofit.data.utility.BaseRepository
import mr.arbn.basehiltretrofit.data.utility.Result
import javax.inject.Inject

class TestRemoteRepoImpl @Inject constructor(private val service: TestApi) : BaseRepository(),
    TestRemoteRepo {
    override suspend fun testApi(testRemoteRequestEntity: TestRemoteRequestEntity): Result<TestRemoteResponseEntity> =
        safeApiCall { service.testApi(testRemoteRequestEntity) }
}