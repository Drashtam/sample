package com.example.mvvma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class Mode : BaseAdapter{

    lateinit var mycontext : Context
    var listFruit = arrayOf<String>()
    lateinit var layoutInflater: LayoutInflater
    constructor(ctx : Context,fruitList: Array<String>){
        this.mycontext = ctx
        this.listFruit = fruitList
        this.layoutInflater = LayoutInflater.from(ctx)

    }
    override fun getCount(): Int {
        return listFruit.size
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}