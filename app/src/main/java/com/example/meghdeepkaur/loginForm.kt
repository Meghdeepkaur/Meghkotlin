package com.example.meghdeepkaur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf

class LoginForm : AppCompatActivity() {
    lateinit var btnLog: Button
    lateinit var etNam: EditText
    lateinit var etPas: EditText
    lateinit var etId: EditText
    lateinit var btnReg: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)
    btnLog = findViewById(R.id.btnLog)
    etNam = findViewById(R.id.etNam)
    etPas = findViewById(R.id.etPas)
        etId = findViewById(R.id.etId)
        btnReg = findViewById(R.id.btnReg)


    btnLog.setOnClickListener {
        onButtonClick()
    }
       // btnReg.setOnClickListener {
        //    ondbClick()
      //  }
   }
    fun onButtonClick() {
        Log.e("loginForm", "Button clicked")
        Log.e("loginForm", etNam.text.toString())
        Log.e("loginForm", etId.text.toString())
        if(etNam.text.toString().isEmpty()) {
            Toast.makeText(this,
                "Name cannot be Empty",
                Toast.LENGTH_LONG).show()
        }
        if(etId.text.toString().isEmpty()) {
            Toast.makeText(this,
                "Email cannot be null. Please enter your Email ID",
                Toast.LENGTH_LONG).show()
        }
        Log.e("MainActivity", "your password is Hidden and secured")
        if(etPas.length()<8) {
            Toast.makeText(this,
                "Password must be AtLeast 8 Characters long",
                Toast.LENGTH_LONG).show()
        }
    }
   fun ondbClick(){
        Log.e("loginForm", "Button clicked")
       val bundle = bundleOf("myText" to etNam.text.toString())
        val intent = Intent(this, MainActivity::class.java)
       intent.putExtras(bundle)
        startActivity(intent)
        this.finish()
    }
}


