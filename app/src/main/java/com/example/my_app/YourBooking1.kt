package com.example.my_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class YourBooking1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_booking1)
        val btn7 = findViewById<Button>(R.id.button7)
        val txtview38 = findViewById<TextView>(R.id.textView38)
        val btn10 = findViewById<Button>(R.id.button10)
        val btn11 = findViewById<Button>(R.id.button11)
        val img2 = findViewById<ImageView>(R.id.imageView2)
        btn7.setOnClickListener{
            val txtview40 = findViewById<TextView>(R.id.textView40)
            val amt = txtview40.text.toString()
            var amtint = amt.toInt()
            if (amtint == 50){
                val intent = Intent(this,Payment1::class.java)
                startActivity(intent)
            }
            else{
                val text = txtview38.text.toString()
                var intval = text.toInt()
                amtint *= intval
                txtview40.text = amtint.toString()
            }

        }

        img2.setOnClickListener{
            val intent = Intent(this,Details::class.java)
            startActivity(intent)
        }



        btn11.setOnClickListener{
            val text = txtview38.text.toString()
            var intval = text.toInt()
            intval++
            txtview38.text = intval.toString()
        }
        btn10.setOnClickListener{
            val text = txtview38.text.toString()
            var intval = text.toInt()
            if (intval == 1){
                txtview38.text = intval.toString()
            }
            else {
                intval--
                txtview38.text = intval.toString()
            }
        }
    }
}