package com.example.instagramclone.utils

object Constants {
    const val TAG: String = "로그"
}

enum class RESPONSE_STATE {
    OKAY,
    FAIL
}

object  API {
    const val BASE_URL : String = "http://3c93733d44f3.ngrok.io"

    const val GET_POSTS : String = "postList"
}