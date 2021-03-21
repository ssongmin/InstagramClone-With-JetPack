package com.example.instagramclone.retrofit.service

import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.retrofit.data.NetworkResult
import com.example.instagramclone.utils.API
import retrofit2.Call
import retrofit2.http.*

interface PostService {

    @GET(API.GET_POSTS)
    suspend fun getPosts() : NetworkResult<List<PostDTO>>
//    suspend fun getPosts() : Call<NetworkResult>

    @GET(API.GET_POSTS)
    suspend fun getPosts(@Query("search")keyword: String) : NetworkResult<List<PostDTO>>

}