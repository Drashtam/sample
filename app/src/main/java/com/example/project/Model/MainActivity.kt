package com.example.project.Model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.project.Model1
import com.example.project.R
import com.example.project.databinding.ActivityMainBinding

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(Model1::class.java)
        binding.viewModel1 = viewModel

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        binding.bottomNavigation.setOnNavigationItemSelectedListener( navListener )
        binding.pagerView.adapter = viewPagerAdapter

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
        HomeFragment()
        ).commit()


        binding.pagerView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position : Int,positionOffset: Float,positionOffsetPixels : Int) {

            }
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {

                        binding.bottomNavigation.menu.findItem(R.id.nav_home).isChecked = true

                    }
                    1 -> {

                        binding.bottomNavigation.menu.findItem(R.id.nav_one).isChecked = true

                    }
                    2 -> {

                        binding.bottomNavigation.menu.findItem(R.id.nav_second).isChecked = true

                    }
                    3 -> {

                        binding.bottomNavigation.menu.findItem(R.id.nav_three).isChecked = true

                    }
                }
            }
        })
    }
//
//    private fun loadFragment(fragment: Fragment) : Boolean{
//        if(fragment == null){
//            val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.fragment_container,fragment)
//            fragmentTransaction.commit()
//            return true
//        }
//        return false
//    }

    private val navListener : BottomNavigationView.OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
      var selectedFragment : Fragment ?= null
        when(it.itemId) {
            R.id.nav_home -> {

                selectedFragment = HomeFragment()
                binding.pagerView.currentItem = 0
            }
            R.id.nav_one -> {
                selectedFragment = FirstFragment()
                binding.pagerView.currentItem = 1

            }
            R.id.nav_second -> {
                selectedFragment = SecondFragment()
                binding.pagerView.currentItem = 2
            }
            R.id.nav_three -> {
                selectedFragment = ThirdFragment()
                binding.pagerView.currentItem = 3
            }
        }

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            selectedFragment!!)
            .commit()
        true
    }
}


