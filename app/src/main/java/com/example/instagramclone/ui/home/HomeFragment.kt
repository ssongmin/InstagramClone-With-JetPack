package com.example.instagramclone.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.viewBindings
import com.example.instagramclone.viewmodel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {
//    private var fragmentHomeBinding: FragmentHomeBinding? = null;
    private val fragmentHomeBinding by viewBindings(FragmentHomeBinding::bind)

//    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter

    companion object {


        fun getInstance() : HomeFragment {
            return  HomeFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentHomeBinding.homeTestBtn?.setOnClickListener(this)
        fragmentHomeBinding.homefragmentUploadBtn?.setOnClickListener(this)

        fragmentHomeBinding.homeMainRecycler?.run {
            var lineartManager = LinearLayoutManager(context)
            layoutManager = lineartManager

            homeAdapter = HomeAdapter(context)
            adapter = homeAdapter

        }

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        homeViewModel.postList.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "!!!", )
            Log.e(TAG, "subscribeObservers: ${it.size}")
            homeAdapter.addData(it)

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

        when(v?.id){
            R.id.home_test_btn ->{
                testInt++
                homeViewModel.setInt(testInt)

            }
            R.id.homefragment_upload_btn->{

            }
        }
    }
}