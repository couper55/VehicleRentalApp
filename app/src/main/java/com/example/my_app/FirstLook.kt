package com.example.my_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.fragment.app.FragmentActivity
import me.relex.circleindicator.CircleIndicator3

class FirstLook : FragmentActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_first_look)

            val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
            val pairPagerAdapter = PairPagerAdapter(this)
            viewPager2.adapter = pairPagerAdapter
            val dotsIndicator = findViewById<CircleIndicator3>(R.id.circleIndicator)
            dotsIndicator.setViewPager(viewPager2)
            val btn2 = findViewById<Button>(R.id.button2)
            btn2.setOnClickListener{
                val intent = Intent(this,Details::class.java)
                startActivity(intent)
            }
            val btn3 = findViewById<Button>(R.id.button3)
            btn3.setOnClickListener{
                val intent = Intent(this,Details::class.java)
                startActivity(intent)
            }
            val btn4 = findViewById<Button>(R.id.button4)
            btn4.setOnClickListener{
                val intent = Intent(this,Details::class.java)
                startActivity(intent)
            }
            val btn5 = findViewById<Button>(R.id.button5)
            btn5.setOnClickListener{
                val intent = Intent(this,Details::class.java)
                startActivity(intent)
            }
            val btn12 = findViewById<Button>(R.id.button12)
            btn12.setOnClickListener{
                val intent = Intent(this,SignUp::class.java)
                startActivity(intent)
            }


        }

}
