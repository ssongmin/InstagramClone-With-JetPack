package com.example.instagramclone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.instagramclone.model.UserDTO
import com.example.instagramclone.model.fakes.fakeUserData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay

class ProfileRepositoryImpl private constructor(ioDispatcher: CoroutineDispatcher): ProfileRepository{

    companion object {
        @Volatile private var instance: ProfileRepositoryImpl? = null

        @JvmStatic fun getInstance(ioDispatcher: CoroutineDispatcher): ProfileRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: ProfileRepositoryImpl(ioDispatcher).also {
                    instance = it
                }
            }
    }


    override fun getProfileData(): MutableLiveData<UserDTO> {

        var data: MutableLiveData<UserDTO> = MutableLiveData()

        data.value = fakeUserData

        return data
    }

    override fun getCurrentTime(): LiveData<Long> =
        liveData {
            while (true) {
                emit(System.currentTimeMillis())
                delay(1000)
            }
        }
}