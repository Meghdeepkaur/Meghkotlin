package com.example.meghdeepkaur

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.meghdeepkaur.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    lateinit var bOne: Button
    lateinit var etName: EditText
    lateinit var etPass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding?.root)
        //btn.setText("click")
        binding?.bOne?.setOnClickListener {
            onButtonClick()
        }

       binding?.bTwo?.setOnClickListener {
           val browserIntent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in"))
           startActivity(browserIntent)
       }

       binding?.bThree?.setOnClickListener {
           val dpIntent= Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+"6284743920"))
           startActivity(dpIntent)
       }
    }
        fun onButtonClick() {
            Log.e("MainActivity", "Button clicked")
            Log.e("MainActivity", etName.text.toString())
            if(etName.text.toString().isEmpty()) {
                Toast.makeText(this,
                    "Name cannot be null",
                    Toast.LENGTH_LONG).show()
            }
            Log.e("MainActivity", "your password is secured")
        }
    }






