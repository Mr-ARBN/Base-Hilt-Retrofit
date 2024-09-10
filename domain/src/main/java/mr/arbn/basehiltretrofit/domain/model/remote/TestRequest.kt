package mr.arbn.basehiltretrofit.domain.model.remote


data class TestRequest(
    val data: Data,
    val name: String
) {
    data class Data(
        val cpuModel: String,
        val hardDiskSize: String,
        val price: Double,
        val year: Int
    )
}