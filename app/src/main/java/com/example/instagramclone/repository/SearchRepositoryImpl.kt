package com.example.instagramclone.repository

import androidx.lifecycle.MutableLiveData
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.retrofit.RetrofitClient
import com.example.instagramclone.retrofit.service.PostService
import com.example.instagramclone.utils.API

class SearchRepositoryImpl : SearchRepository{

    override suspend fun searchPostList(keyword: String): MutableLiveData<List<PostDTO>> {


        var data: MutableLiveData<List<PostDTO>> = MutableLiveData<List<PostDTO>>()

        var server = RetrofitClient.getClient(API.BASE_URL)?.create(PostService::class.java)

        var postList = server?.getPosts(keyword)?.data

        data.value= postList

        return data
    }
}