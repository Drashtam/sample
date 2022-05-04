package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

lateinit var bottomNavigationView :  BottomNavigationView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener( navListener )

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
        HomeFragment()).commit()

    }

    private val navListener : BottomNavigationView.OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
      var selectedFragment : Fragment ?= null
        when(it.itemId) {
            R.id.nav_home -> {
                selectedFragment = HomeFragment()
            }
            R.id.nav_one -> {
                selectedFragment = FirstFragment()
            }
            R.id.nav_second -> {
                selectedFragment = SecondFragment()
            }
            R.id.nav_three-> {
                selectedFragment = ThirdFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            selectedFragment!!)
            .commit()
        true
    }
}