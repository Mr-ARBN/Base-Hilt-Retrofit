package com.example.basehiltretrofit.data.source.remote.repository

import com.example.basehiltretrofit.data.entity.remote.TestRequestEntity
import com.example.basehiltretrofit.data.entity.remote.TestResponse
import com.example.basehiltretrofit.data.source.remote.service.TestApi
import com.example.basehiltretrofit.data.utility.BaseRepository
import com.example.basehiltretrofit.data.utility.Result
import javax.inject.Inject

class TestRepoImpl @Inject constructor(private val service: TestApi) : BaseRepository(), TestRepo {
    override suspend fun testApi(testRequestEntity: TestRequestEntity): Result<TestResponse> =
        safeApiCall {
            service.testApi(testRequestEntity)
        }
}