package com.example.instagramclone.repository

import com.example.instagramclone.model.PostDTO

object HomeRepositoryImpl : HomeRepository{
    override suspend fun getPostList(): List<PostDTO> {
        var testList: List<PostDTO> = mutableListOf(PostDTO())

        return testList
    }
}