package com.example.meghdeepkaur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.meghdeepkaur.databinding.ActivityFragNavBinding

class FragNav : AppCompatActivity() {
    lateinit var navController: NavController
    var binding: ActivityFragNavBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragNavBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_frag_nav)
        setContentView(binding?.root)
        navController = findNavController(R.id.navController)

        setSupportActionBar(binding?.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupActionBarWithNavController(navController)



        binding?.bott?.setOnItemSelectedListener { menuItemSelected ->
            when (menuItemSelected.itemId) {
                R.id.home -> navController.navigate(R.id.meghFragment)
                R.id.person -> navController.navigate(R.id.firstFragment)
                R.id.more -> navController.navigate(R.id.registrationFragment)
            }
            return@setOnItemSelectedListener true
        }
    }


        override fun onDestroy() {
            super.onDestroy()
            binding = null
        }

        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()

        }

        fun updateAppBarTitle(title: String) {
            binding?.tvTool1?.text = title
        }
    }