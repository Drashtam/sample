package com.example.mvvma.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvma.Model
import com.example.mvvma.R
import com.example.mvvma.databinding.ActivityMainBinding
//import com.example.mvvma.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.FirebaseDatabase.getInstance
import java.util.Calendar.getInstance


//import com.example.mvvma.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(Model::class.java)
        binding.viewModel = viewModel
//        setContentView(R.layout.activity_main)
//        val viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
//        binding.viewModel = viewModel as Model?
//        var model = Model()
//            binding.viewModel = mode
//            intent.putExtra("name",binding.editText1.text.toString())
//            intent.putExtra("password",binding.editText2.text.toString())
//            startActivity(intent)
//            if(uid != null){
//                dataBaseRefrence.child(uid).setValue(model).addOnCompleteListener {
//                    if(it.isSuccessful){
//
//                    }
//                    else{
//                        Toast.makeText(this@MainActivity,"Data Found",Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        binding.signup.setOnClickListener {
//
//        }



    }

}