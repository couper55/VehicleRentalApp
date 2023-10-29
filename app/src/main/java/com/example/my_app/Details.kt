package com.example.my_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.my_app.FirstLook
class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val btn6 = findViewById<Button>(R.id.button6)
        val img8 = findViewById<ImageView>(R.id.imageView8)
        btn6.setOnClickListener{
            val intent = Intent(this,YourBooking1::class.java)
            startActivity(intent)
        }
        img8.setOnClickListener{
            val intent = Intent(this,FirstLook::class.java)
            startActivity(intent)
        }
    }
}