package com.example.meghdeepkaur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.meghdeepkaur.databinding.ActivityFragNavBinding

class FragNav : AppCompatActivity() {
    lateinit var navController: NavController
    var binding: ActivityFragNavBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFragNavBinding.inflate(layoutInflater)
       // setContentView(R.layout.activity_frag_nav)
        setContentView(binding?.root)
        navController=findNavController(R.id.navController)
    }
}