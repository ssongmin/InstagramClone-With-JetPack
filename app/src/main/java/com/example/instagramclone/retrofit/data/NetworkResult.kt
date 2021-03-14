package com.example.instagramclone.retrofit.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NetworkResult<T> (
    @SerializedName("data")
    @Expose
    public val data: T?,
    @SerializedName("isSuccess")
    @Expose
    public val isSuccess: Boolean? = false,
    @SerializedName("code")
    @Expose
    public val code: Int? = -1,
    )