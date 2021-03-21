package com.example.instagramclone.utils

object Constants {
    const val TAG: String = "로그"
}

enum class RESPONSE_STATE {
    OKAY,
    FAIL
}

object  API {
    const val BASE_URL : String = "http://3214c7565cd8.ngrok.io"

    const val GET_POSTS : String = "postList"
}