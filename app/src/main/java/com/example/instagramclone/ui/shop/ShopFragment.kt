package com.example.instagramclone.ui.shop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentShopBinding
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.viewBindings

class ShopFragment : Fragment(R.layout.fragment_shop) {

    private val fragmentShopBinding by viewBindings(FragmentShopBinding::bind)

    private lateinit var shopViewModel: ShopViewModel
    private lateinit var shopAdapter: ShopAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shopViewModel = ViewModelProvider(this).get(ShopViewModel::class.java)

        fragmentShopBinding.shopMainRecycler?.run {
            var gridLayoutManager = GridLayoutManager(context, 2)
            layoutManager = gridLayoutManager
            shopAdapter = ShopAdapter(context)
            adapter = shopAdapter
        }

        subscribeObservers()
    }

    private fun subscribeObservers() {
        shopViewModel.shopList.observe(viewLifecycleOwner, {
            shopAdapter.setData(it)
        })
    }

    override fun onResume() {
        super.onResume()
        shopViewModel.getShopList()
    }
}