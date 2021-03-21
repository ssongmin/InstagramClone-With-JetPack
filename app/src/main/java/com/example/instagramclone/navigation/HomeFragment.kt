package com.example.instagramclone.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.viewmodel.HomeViewModel

class HomeFragment : Fragment(), View.OnClickListener {
    private var fragmentHomeBinding: FragmentHomeBinding? = null;
//    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding

        fragmentHomeBinding?.homeTestBtn?.setOnClickListener(this)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        subscribeObservers()
        return  fragmentHomeBinding!!.root
    }

    private fun subscribeObservers() {
        homeViewModel.postList.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "!!!", )
            Log.e(TAG, "subscribeObservers: ${it.size}")

        })

        homeViewModel.testInt.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "subscribeObservers: $it")
        })
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getPostList()
    }

    var testInt: Int = 1;
    override fun onClick(v: View?) {
        testInt++
        homeViewModel.setInt(testInt)
    }

    companion object {
        fun newInstance() : HomeFragment{
            return  HomeFragment()
        }
    }

    override fun onDestroy() {
        fragmentHomeBinding = null
        super.onDestroy()
    }
}