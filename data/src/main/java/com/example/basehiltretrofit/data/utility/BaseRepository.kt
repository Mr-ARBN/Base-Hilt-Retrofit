package com.example.basehiltretrofit.data.utility

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

abstract class BaseRepository {
    suspend fun <T : Any> safeApiCall(apiCall: suspend () -> Response<T>): Result<T> {
        return try {
            val response: Response<T> = apiCall()
            val body: T? = response.body()
            when {
                response.code() == 204 -> Result.Success(null as T)
                response.isSuccessful && body != null -> Result.Success(body)
                else -> {
                    val errorBody: ResponseBody? = response.errorBody()
                    val errorContent: String =
                        if (errorBody != null) getErrorContent(errorBody)
                        else DEFAULT_ERROR_MESSAGE
                    Result.Error(errorContent)
                }
            }
        } catch (e: Exception) {
            Result.Error(
                DEFAULT_TIMEOUT_ERROR_MESSAGE,
            )
        }
    }

    private fun getErrorContent(responseBody: ResponseBody): String {
        return try {
            val jsonObject = JSONObject(responseBody.string())
            val actionMessage =
                if (jsonObject.has(ACTION_MESSAGE_KEY)) jsonObject.getString(ACTION_MESSAGE_KEY) else DEFAULT_ERROR_MESSAGE
            if (jsonObject.has(ACTION_CODE_KEY)) jsonObject.getString(ACTION_CODE_KEY)
            actionMessage
        } catch (e: Exception) {
            DEFAULT_ERROR_MESSAGE
        }
    }

    companion object {
        private const val ACTION_MESSAGE_KEY = "actionMessage"
        private const val ACTION_CODE_KEY = "actionCode"
        private const val DEFAULT_ERROR_MESSAGE = "مشکلی پیش آمده است، لطفا دقایقی دیگر تلاش کنید."
        private const val DEFAULT_TIMEOUT_ERROR_MESSAGE = "در ارتباط با سرور مشکلی پیش امده است"
    }
}