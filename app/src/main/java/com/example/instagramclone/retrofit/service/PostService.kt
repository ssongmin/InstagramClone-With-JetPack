package com.example.instagramclone.retrofit.service

import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.retrofit.data.NetworkResult
import com.example.instagramclone.utils.API
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PostService {

    @GET(API.GET_POSTS)
    suspend fun getPosts() : NetworkResult<List<PostDTO>>
//    suspend fun getPosts() : Call<NetworkResult>

}