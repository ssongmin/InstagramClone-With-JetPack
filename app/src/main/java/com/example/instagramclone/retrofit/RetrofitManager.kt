package com.example.instagramclone.retrofit

import android.util.Log
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.retrofit.service.PostService
import com.example.instagramclone.utils.API
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.utils.RESPONSE_STATE
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object{
        val instance = RetrofitManager()
    }

    private val iRetrofit: PostService? = RetrofitClient.getClient(API.BASE_URL)?.create(PostService::class.java)

    fun getPosts(completion: (RESPONSE_STATE, String) -> Unit){

        //call null 이면 return
        val call = iRetrofit?.getPosts().let {
            it
        }?: return

//        call.enqueue(object : retrofit2.Callback<PostDTO> {
//            override fun onResponse(call: Call<PostDTO>, response: Response<PostDTO>) {
//                Log.d(TAG, "onResponse: called / response : ${response.body()}")
//                completion(RESPONSE_STATE.OKAY, response.body().toString())
//            }
//
//            override fun onFailure(call: Call<PostDTO>, t: Throwable) {
//                completion(RESPONSE_STATE.FAIL, t.toString())
//            }
//        })
    }
}