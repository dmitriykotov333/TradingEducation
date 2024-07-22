package com.kotdev.trading.service.api

import kotlinx.serialization.Serializable

@Serializable
sealed class ApiResult<T> {
    class Success<T>(val data: T?) : ApiResult<T>()
    class Error<T>(val error: String?) : ApiResult<T>()
    class Loading<T> : ApiResult<T>()
}