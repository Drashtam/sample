package com.example.project.Model

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlin.coroutines.coroutineContext


class ViewPagerAdapter(val fragment: FragmentManager) : FragmentStatePagerAdapter(fragment) {

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                println("Home")
                return HomeFragment()
            }
            1 -> {
                println("First")
                return FirstFragment()
            }
            2 -> {
                println("Second")
                return SecondFragment()
            }
            3 -> {
                println("Third")
                return ThirdFragment()
            }
            else -> {
                println("Fourth")
                return Fragment()
            }
        }
    }
}