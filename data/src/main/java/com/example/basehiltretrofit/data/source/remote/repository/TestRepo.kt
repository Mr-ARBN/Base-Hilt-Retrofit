package com.example.basehiltretrofit.data.source.remote.repository

import com.example.basehiltretrofit.data.entity.remote.TestRequestEntity
import com.example.basehiltretrofit.data.entity.remote.TestResponseEntity
import com.example.basehiltretrofit.data.utility.Result

interface TestRepo {
    suspend fun testApi(testRequestEntity: TestRequestEntity): Result<TestResponseEntity>
}