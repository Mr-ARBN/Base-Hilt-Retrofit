package com.example.basehiltretrofit.data.entity.remote
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class TestRequestEntity(
    @Json(name = "CPU model")
    val cPUModel: String,
    @Json(name = "Hard disk size")
    val hardDiskSize: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "year")
    val year: Int,
    @Json(name = "name")
    val name: String
)