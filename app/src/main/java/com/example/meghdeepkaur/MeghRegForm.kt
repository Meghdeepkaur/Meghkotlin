package com.example.meghdeepkaur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MeghRegForm : AppCompatActivity() {
   // var binding: MeghRegForm ?= null
        lateinit var reg: Button
        lateinit var reg_name: EditText
        lateinit var reg_mail: EditText
        lateinit var reg_ph: EditText
        lateinit var reg_pas: EditText
        lateinit var reg_cpas: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_megh_reg_form)

        val test = intent.extras
        val tvSix: EditText = findViewById(R.id.reg_name)
        tvSix.setText(test?.getString("myText") ?: "Name")

            reg = findViewById(R.id.reg)
            reg_name = findViewById(R.id.reg_name)
            reg_mail = findViewById(R.id.reg_mail)
            reg_ph = findViewById(R.id.reg_ph)
            reg_pas = findViewById(R.id.reg_pas)
        reg_cpas = findViewById(R.id.reg_cpas)
            reg.setOnClickListener {
                onButtonClick()
            }
        }
        fun onButtonClick() {
            Log.e("loginForm", "Button clicked")
            Log.e("loginForm", reg_name.text.toString())
            Log.e("loginForm", reg_mail.text.toString())
            if(reg_name.text.toString().isEmpty()) {
                Toast.makeText(this,
                    "Name cannot be Empty",
                    Toast.LENGTH_LONG).show()
            }
            else if(reg_mail.text.toString().isEmpty()) {
                Toast.makeText(this,
                    "Email cannot be null. Please enter your Email ID",
                    Toast.LENGTH_LONG).show()
            }
            else if(reg_ph.length()<10) {
                Toast.makeText(this,
                    "Phone number must be AtLeast 10 character long",
                    Toast.LENGTH_LONG).show()
                Log.e("MainActivity", "your password is Hidden and secured")
            }

            else if(reg_pas.length()<8) {
                Toast.makeText(this,
                    "Password must be AtLeast 8 Characters long",
                    Toast.LENGTH_LONG).show()
            }
            else if(reg_cpas!=reg_pas) {
                Toast.makeText(
                    this,
                    "Password  match",
                    Toast.LENGTH_LONG).show()
            }
            else{
                    Toast.makeText(
                        this,
                        "VALID CREDENTIALS.",
                        Toast.LENGTH_LONG).show()
            }
        }
    }

