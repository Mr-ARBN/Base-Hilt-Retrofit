package com.example.basehiltretrofit.domain.model.remote

data class TestResponse(
    val createdAt: String,
    val data: Data,
    val id: String,
    val name: String
) {
    data class Data(
        val cPUModel: String,
        val hardDiskSize: String,
        val price: Double,
        val year: Int
    )
}

