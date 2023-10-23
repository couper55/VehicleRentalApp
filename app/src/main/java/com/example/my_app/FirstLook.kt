package com.example.my_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.fragment.app.FragmentActivity

class FirstLook : FragmentActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_first_look)

            val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
            val pairPagerAdapter = PairPagerAdapter(this)
            viewPager2.adapter = pairPagerAdapter
        }

}
