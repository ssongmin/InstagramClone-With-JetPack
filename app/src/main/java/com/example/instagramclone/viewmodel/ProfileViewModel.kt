package com.example.instagramclone.viewmodel

import androidx.lifecycle.*
import com.example.instagramclone.repository.ProfileRepository
import com.example.instagramclone.repository.ProfileRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class ProfileViewModel(
    private val dataSource: ProfileRepository
): ViewModel() {
    val currentTime = dataSource.getCurrentTime()

//    val currentTimeTransformed = currentTime.switchMap {
//        // timeStampToTime is a suspend function so we need to call it from a coroutine.
//        liveData { emit(timeStampToTime(it)) }
//    }
//
//    private suspend fun timeStampToTime(timestamp: Long): String {
//        delay(500)  // Simulate long operation
//        val date = Date(timestamp)
//        return date.toString()
//    }

    val userProfileData = dataSource.getProfileData()
}

object ProfileVMFactory: ViewModelProvider.Factory{
    private  val dataSource = ProfileRepositoryImpl.getInstance(Dispatchers.IO)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return ProfileViewModel(dataSource) as T
    }
}