package com.example.instagramclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.repository.HomeRepositoryImpl
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers.Main

class HomeViewModel : ViewModel() {

    private val _postList = MutableLiveData<List<PostDTO>>()

    val postList : LiveData<List<PostDTO>>
        get() = _postList
    init {
        viewModelScope.launch {
            val postList = HomeRepositoryImpl.getPostList()
            withContext(Main) {
                _postList.value = postList
            }
        }
    }


}