package com.example.instagramclone.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.model.fakes.fakePostItemList
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
//        viewModelScope.launch {
//
//            val searchRepositoryImpl: SearchRepositoryImpl = SearchRepositoryImpl()
//            val postList = searchRepositoryImpl.searchPostList(keyword)
//            withContext(Dispatchers.Main) {
//                _postList.value= postList.value
//            }
//        }
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _postList.value = fakePostItemList.filter { postDTO: PostDTO ->
                    postDTO.post_content.let { content ->
                        content!!.contains(keyword)
                    }
                }

            }
        }


    }

    fun defaultPostList() {

        _postList.value = fakePostItemList

//        viewModelScope.launch {
//            val searchRepositoryImpl: SearchRepositoryImpl = SearchRepositoryImpl()
//            val postList = searchRepositoryImpl.searchPostList("")
//            withContext(Dispatchers.Main) {
//                _postList.value= postList.value
//            }
//        }

    }

}