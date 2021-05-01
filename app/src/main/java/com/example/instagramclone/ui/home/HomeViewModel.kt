package com.example.instagramclone.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.model.fakes.fakePostItemList
import com.example.instagramclone.repository.HomeRepositoryImpl
import com.example.instagramclone.utils.Constants
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers.Main

class HomeViewModel : ViewModel() {

    private val _postList:MutableLiveData<List<PostDTO>> = MutableLiveData()
    private val _testInt: MutableLiveData<Int> = MutableLiveData()

    val postList : LiveData<List<PostDTO>>
        get() = _postList

    val testInt: LiveData<Int>
        get() = _testInt


    init {
        _testInt.value = 0
    }

    fun setInt(test: Int){
        _testInt.value = test
    }

    fun getPostList() {

        _postList.value = fakePostItemList

//        viewModelScope.launch {
//            val homeRepositoryImpl: HomeRepositoryImpl = HomeRepositoryImpl()
//            val postList = homeRepositoryImpl.getPostList()
//            withContext(Main) {
//                _postList.value= postList.value
//            }
//        }
    }

}