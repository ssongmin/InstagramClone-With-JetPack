package com.example.instagramclone.retrofit

data class NetworkResult<T> (
    var data: T? = null,
    var isSuccess: Boolean = false,
    var code: Int = -1,
    )