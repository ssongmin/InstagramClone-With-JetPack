package com.example.instagramclone.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentProfileBinding
import com.example.instagramclone.viewBindings
import com.example.instagramclone.viewmodel.ProfileVMFactory
import com.example.instagramclone.viewmodel.ProfileViewModel


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
//    private var fragmentProfileBinding : FragmentProfileBinding? = null
//    private val fragmentProfileBinding by viewBindings(FragmentProfileBinding::bind)



    private val viewmodel: ProfileViewModel by viewModels { ProfileVMFactory }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//    }

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)

        binding?.lifecycleOwner = viewLifecycleOwner

        binding?.viewmodel = viewmodel


        return binding?.root
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment()
    }
}