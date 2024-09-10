package mr.arbn.basehiltretrofit.data.entity.remote
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class TestRemoteRequestEntity(
    @Json(name = "data")
    val data: TestDataRequestEntity,
    @Json(name = "name")
    val name: String
) {
    @JsonClass(generateAdapter = true)
    data class TestDataRequestEntity(
        @Json(name = "CPU model")
        val cpuModel: String,
        @Json(name = "Hard disk size")
        val hardDiskSize: String,
        @Json(name = "price")
        val price: Double,
        @Json(name = "year")
        val year: Int
    )
}