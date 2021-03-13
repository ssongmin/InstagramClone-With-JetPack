package com.example.instagramclone.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.retrofit.NetworkResult
import com.example.instagramclone.retrofit.RetrofitClient
import com.example.instagramclone.retrofit.service.PostService
import com.example.instagramclone.utils.API
import com.example.instagramclone.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), View.OnClickListener {
    private var fragmentHomeBinding: FragmentHomeBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding

        fragmentHomeBinding?.homeTestBtn?.setOnClickListener(this)

        return  fragmentHomeBinding!!.root
    }

    override fun onClick(v: View?) {
        var server = RetrofitClient.getClient(API.BASE_URL)?.create(PostService::class.java)

        server?.getPosts()?.enqueue(object : Callback<NetworkResult<List<PostDTO>>>{
            override fun onResponse(
                call: Call<NetworkResult<List<PostDTO>>>,
                response: Response<NetworkResult<List<PostDTO>>>
            ) {
                Log.e(TAG, "success")
                Log.e(TAG, "onResponse: ${response.body()}")
                Log.e(TAG, "onResponse: ${response.raw()}")
            }
            override fun onFailure(call: Call<NetworkResult<List<PostDTO>>>, t: Throwable) {
                Log.e(TAG, "onResponse: ${t.toString()}", )
            }
        })
    }

    companion object {
        fun newInstance() : HomeFragment{
            return  HomeFragment()
        }
    }
}