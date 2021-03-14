package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        var navHostFramgnet = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment

        var navController = navHostFramgnet.navController

        NavigationUI.setupWithNavController(mainBinding.mainBottomNav, navController)
    }
}