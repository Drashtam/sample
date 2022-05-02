package com.example.mvvma.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.mvvma.Model2
import com.example.mvvma.R
import com.example.mvvma.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        val viewModel2 = ViewModelProvider(this).get(Model2::class.java)
        binding.viewModel2 = viewModel2
        val userName : String ?= intent.getStringExtra("userName")
        val userPassword : String ?= intent.getStringExtra("userPassword")
        viewModel2.userName_1 = userName
        viewModel2.userPassword_2 = userPassword

        val main = MainActivity3()
        binding.button2.setOnClickListener {
            main.show(supportFragmentManager,"exampleBottomSheet")
        }
    }

}