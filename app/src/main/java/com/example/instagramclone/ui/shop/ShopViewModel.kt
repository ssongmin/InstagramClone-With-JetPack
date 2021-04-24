package com.example.instagramclone.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclone.model.ShopDTO
import com.example.instagramclone.model.fakes.fakeShopItemList

class ShopViewModel: ViewModel() {
    private val _shopList: MutableLiveData<List<ShopDTO>> = MutableLiveData()

    val shopList: LiveData<List<ShopDTO>>
        get() = _shopList

    fun getShopList() {
        _shopList.value = fakeShopItemList
    }
}