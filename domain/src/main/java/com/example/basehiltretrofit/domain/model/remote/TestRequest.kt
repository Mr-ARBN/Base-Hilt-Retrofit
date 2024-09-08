package com.example.basehiltretrofit.domain.model.remote

data class TestRequest(
    val cPUModel: String,
    val hardDiskSize: String,
    val price: Double,
    val year: Int,
    val name: String
)