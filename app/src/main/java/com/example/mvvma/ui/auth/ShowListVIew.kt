package com.example.mvvma.ui.auth


import android.content.Intent
import android.content.Intent.getIntent

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvma.Model6
import com.example.mvvma.R
import com.example.mvvma.databinding.ActivityMain2Binding.inflate
import com.example.mvvma.databinding.ActivityShowListViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShowListVIew : BottomSheetDialogFragment() {

//    private lateinit var binding: ShowListVIew

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val V : View = inflater.inflate(R.layout.activity_show_list_view,container,false)
        val binding = ActivityShowListViewBinding.inflate(inflater,container,false)
        val viewModel6 = ViewModelProvider(this).get(Model6::class.java)
        val data_1 = arguments?.getString("Name")
        val data_2 = arguments?.getString("Email")
        viewModel6.Str1 = data_1
        viewModel6.Str2 = data_2
        binding.viewModel6 = viewModel6
//        val intent = intent
//        Toast.makeText(context,"Inside Activity",Toast.LENGTH_SHORT).show()
        return binding.root
    }
}