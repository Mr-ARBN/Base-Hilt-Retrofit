package mr.arbn.basehiltretrofit.data.source.remote.repository

import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteRequestEntity
import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteResponseEntity
import mr.arbn.basehiltretrofit.data.utility.Result

interface TestRemoteRepo {
    suspend fun testApi(testRemoteRequestEntity: TestRemoteRequestEntity): Result<TestRemoteResponseEntity>
}