package com.example.instagramclone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagramclone.model.UserDTO

interface ProfileRepository {
    fun getProfileData() : MutableLiveData<UserDTO>
    fun getCurrentTime() : LiveData<Long>
}