package com.example.instagramclone

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InstagramApplication: Application(){
    companion object {
        private var context: Context? = null

        fun getContext() : Context {
            return context!!
        }
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}