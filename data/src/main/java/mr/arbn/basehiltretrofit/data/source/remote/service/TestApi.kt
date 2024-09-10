package mr.arbn.basehiltretrofit.data.source.remote.service

import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteRequestEntity
import mr.arbn.basehiltretrofit.data.entity.remote.TestRemoteResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TestApi {
    @POST("objects")
    suspend fun testApi(
        @Body testRemoteRequestEntity: TestRemoteRequestEntity
    ): Response<TestRemoteResponseEntity>
}