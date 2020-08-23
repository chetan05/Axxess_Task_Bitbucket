package com.example.axxess_task.network

import okhttp3.ResponseBody


sealed class APIResult<out T: Any>{
    data class Success<out T: Any>(val data: T?): APIResult<T>()
    data class Error(val errorBody: Any?): APIResult<Nothing>()
}