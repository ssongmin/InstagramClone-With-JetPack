package com.example.instagramclone.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentProfileBinding
import com.example.instagramclone.viewBindings


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
//    private var fragmentProfileBinding : FragmentProfileBinding? = null
    private val fragmentProfileBinding by viewBindings(FragmentProfileBinding::bind)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_profile, container, false)

//        val binding = FragmentProfileBinding.inflate(inflater, container, false)
//        fragmentProfileBinding = binding


        return  fragmentProfileBinding!!.root
    }

    override fun onDestroy() {
//        fragmentProfileBinding = null
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment()
    }
}