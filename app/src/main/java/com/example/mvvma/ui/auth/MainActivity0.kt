package com.example.mvvma.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvma.Model3
import com.example.mvvma.R
import android.R.layout
import com.example.mvvma.databinding.ActivityMain4Binding

class MainActivity0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMain4Binding = DataBindingUtil.setContentView(this, R.layout.activity_main4)
        val viewModel4 = ViewModelProvider(this).get(Model3::class.java)
        binding.viewModel4 = viewModel4
    }
}