package com.example.instagramclone.utils

import android.content.Intent
import android.util.SparseArray
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.setupWithNavController(
    navGraphIds: List<Int>,
    fragmentManager: FragmentManager,
    containerId: Int,
    intent: Intent
): LiveData<NavController> {
    val graphIdToTagMap = SparseArray<String>()

    val selectedNavController = MutableLiveData<NavController>()

    var firstFragmentGraphId = 0

    navGraphIds.forEachIndexed { index, navGraphId ->
        val fragmentTag = getFragmentTag(index)


    }
}

private fun getFragmentTag(index: Int) = "bottomNavigation#$index"