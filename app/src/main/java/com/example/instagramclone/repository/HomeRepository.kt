package com.example.instagramclone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagramclone.model.PostDTO

interface HomeRepository{
    suspend fun getPostList() : MutableLiveData<List<PostDTO>>
}