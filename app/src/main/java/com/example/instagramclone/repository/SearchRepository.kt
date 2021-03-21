package com.example.instagramclone.repository

import androidx.lifecycle.MutableLiveData
import com.example.instagramclone.model.PostDTO

interface SearchRepository{
    suspend fun searchPostList(keyword: String) : MutableLiveData<List<PostDTO>>
}