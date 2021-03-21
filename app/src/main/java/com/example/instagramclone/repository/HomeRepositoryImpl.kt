package com.example.instagramclone.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.retrofit.data.NetworkResult
import com.example.instagramclone.retrofit.RetrofitClient
import com.example.instagramclone.retrofit.service.PostService
import com.example.instagramclone.utils.API
import com.example.instagramclone.utils.Constants
import com.example.instagramclone.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRepositoryImpl constructor() : HomeRepository {
    override suspend fun getPostList(): MutableLiveData<List<PostDTO>> {
//        var testList: List<PostDTO> = mutableListOf(PostDTO())
//        return testList
//        val data: MutableLiveData<List<PostDTO>> = MutableLiveData<List<PostDTO>>()
        var data: MutableLiveData<List<PostDTO>> = MutableLiveData<List<PostDTO>>()

        var server = RetrofitClient.getClient(API.BASE_URL)?.create(PostService::class.java)
//        server?.getPosts()?.enqueue(object : Callback<NetworkResult<List<PostDTO>>> {
//            override fun onResponse(
//                call: Call<NetworkResult<List<PostDTO>>>,
//                response: Response<NetworkResult<List<PostDTO>>>
//            ) {
//                Log.e(Constants.TAG, "success")
//                Log.e(Constants.TAG, "onResponse: ${response.body()}")
//                Log.e(Constants.TAG, "onResponse: ${response.raw()}")
//                Log.e(Constants.TAG, "onResponse: ${response.body()?.data?.size}")
//                Log.e(Constants.TAG, "onResponse: ${response.body()?.data?.get(0)}")
//
//                data.postValue(response.body()?.data!!)
////                data = response.body()?.data!!
//            }
//
//            override fun onFailure(call: Call<NetworkResult<List<PostDTO>>>, t: Throwable) {
//                Log.e(Constants.TAG, "fail")
//                Log.e(Constants.TAG, "onResponse: ${t.toString()}")
//                val tempList: List<PostDTO> = ArrayList()
//                data.postValue(tempList)
////                data = tempList
//            }
//        })

        var postList = server?.getPosts()?.data

        data.value= postList

        return data
    }
}