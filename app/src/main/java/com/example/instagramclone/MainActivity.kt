package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    //    private lateinit var mainBinding : ActivityMainBinding
    private val mainBinding by viewBindings(ActivityMainBinding::bind)

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
//        var navHostFramgnet = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
//
//        var navController = navHostFramgnet.navController
//        NavigationUI.setupWithNavController(mainBinding.mainBottomNav, navController)

        val bottomNavigationView: BottomNavigationView = mainBinding.mainBottomNav
//        val bottomNavigationView = findViewById<BottomNavigationItemView>(R.id.main_bottom_nav)

        val navGraphIds = listOf(
            R.navigation.home,
            R.navigation.search,
            R.navigation.reels,
            R.navigation.shop,
            R.navigation.profile
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_nav_host,
            intent = intent
        )

        controller.observe(this, {navController ->
            setupActionBarWithNavController(navController)
        })

        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}