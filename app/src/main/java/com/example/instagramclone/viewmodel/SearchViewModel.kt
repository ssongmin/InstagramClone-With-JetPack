package com.example.instagramclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.repository.HomeRepositoryImpl
import com.example.instagramclone.repository.SearchRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel(){
    private val _postList: MutableLiveData<List<PostDTO>> = MutableLiveData()

    val postList : LiveData<List<PostDTO>>
        get() = _postList




    init {
    }

    fun searchPost(keyword: String){
        viewModelScope.launch {

            val searchRepositoryImpl: SearchRepositoryImpl = SearchRepositoryImpl()
            val postList = searchRepositoryImpl.searchPostList(keyword)
            withContext(Dispatchers.Main) {
                _postList.value= postList.value
            }
        }
    }

    fun defaultPostList() {
        viewModelScope.launch {
            val searchRepositoryImpl: SearchRepositoryImpl = SearchRepositoryImpl()
            val postList = searchRepositoryImpl.searchPostList("")
            withContext(Dispatchers.Main) {
                _postList.value= postList.value
            }

        }
    }

}