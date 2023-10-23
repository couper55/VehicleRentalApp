package com.example.my_app

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import PairFragment1

class PairPagerAdapter(fragment: FirstLook) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3 // Number of pairs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PairFragment1()
            1 -> PairFragment2()
            2 -> PairFragment3()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
