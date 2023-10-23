package com.example.my_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val btn1=findViewById<Button>(R.id.button)
        btn1.setBackgroundColor(Color.parseColor("#4B1CB8"))
        btn1.setOnClickListener {
            val intent = Intent(this, FirstLook::class.java)
            startActivity(intent)
        }
    }
}