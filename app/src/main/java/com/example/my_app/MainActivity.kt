package com.example.my_app

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.TextView

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1=findViewById<Button>(R.id.btn)
        btn1.setBackgroundColor(Color.parseColor("#4B1CB8"))
        btn1.setOnClickListener {
            val intent = Intent(this, newaccount::class.java)
            startActivity(intent)
        }
        val textView=findViewById<TextView>(R.id.textView3)
        //val text = textView.text.toString()
        //text.setBackgroundColor(Color.parseColor("#4B1CB8"))
        textView.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }
}