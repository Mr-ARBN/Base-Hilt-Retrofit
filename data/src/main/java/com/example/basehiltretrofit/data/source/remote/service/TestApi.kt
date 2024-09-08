package com.example.basehiltretrofit.data.source.remote.service

import com.example.basehiltretrofit.data.entity.remote.TestRequestEntity
import com.example.basehiltretrofit.data.entity.remote.TestResponseEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TestApi {
    @POST("objects")
    suspend fun testApi(
        @Body testRequestEntity: TestRequestEntity
    ): Response<TestResponseEntity>
}