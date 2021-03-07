package com.example.instagramclone.repository

import com.example.instagramclone.model.PostDTO

interface HomeRepository{
    suspend fun getPostList() : List<PostDTO>
}