package com.example.my_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SuccessPayment1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_payment1)
        val btn3 = findViewById<Button>(R.id.button3)
        btn3.setOnClickListener{
            val intent = Intent(this,FirstLook::class.java)
            startActivity(intent)
        }
    }
}