package com.example.mvvma.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.allViews
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvma.*
import com.example.mvvma.databinding.ActivityListViewAndroidBinding

class ListVIewAndroid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Toast.makeText(applicationContext,"Activity Created",Toast.LENGTH_SHORT).show()
//        setContentView(R.layout.activity_list_view_android)
        val binding : ActivityListViewAndroidBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_view_android)
        val viewModel5 = ViewModelProvider(this).get(Model4::class.java)
        binding.viewModel5 = viewModel5


//        val strArray1 = arrayOf("agapow","lbaxter","mmccool","dmiller","burniske","stevelim","wayward","adillon","grolschie","gmcgath","camenisch","thrymm")
//        val strArray2 = arrayOf("agapow@aol.com","lbaxter@yahoo.com","mmccool@att.net","dmiller@outlook.com","burniske@optonline.net","stevelim@outlook.com",
//            "wayward@icloud.com","adillon@gmail.com","grolschie@yahoo.com","gmcgath@me.com","camenisch@msn.com","thrymm@att.net"
//        )

        val hashMap = HashMap<String,String>()
        hashMap.put("agapow","agapow@aol.com")
        hashMap.put("lbaxter","lbaxter@yahoo.com")
        hashMap.put("mmccool","mmccool@att.net")
        hashMap.put("dmiller","dmiller@outlook.com")
        hashMap.put("burniske","burniske@optonline.net")
        hashMap.put("stevelim","stevelim@outlook.com")
        hashMap.put("wayward","wayward@icloud.com")
        hashMap.put("adillon","adillon@gmail.com")
        hashMap.put("grolschie","grolschie@yahoo.com")
        hashMap.put("gmcgath", "gmcgath@me.com")
        hashMap.put("camenisch", "camenisch@msn.com")
        hashMap.put("thrymm","thrymm@att.net")
        var list = ArrayList<HashMap<String,String>>()
        val string = arrayOf("First","Second")
        val intArr = arrayOf(R.id.text_1,R.id.text_2)
        var simpleAdapter : SimpleAdapter = SimpleAdapter(this,list,R.layout.items,string,intArr.toIntArray())

        val iterator = hashMap.entries.iterator()

        while (iterator.hasNext()){
            val map = HashMap<String,String>()
            val pair = iterator.next()
            map.put("First",pair.key)
            map.put("Second",pair.value)
            list.add(map)

        }
        binding.listview.adapter = simpleAdapter

        binding.listview.setOnItemClickListener { adapterView : AdapterView<*>, view : View, position : Int, id : Long ->
            val intent = Intent(applicationContext,ShowListVIew::class.java)
//            Toast.makeText(applicationContext,SimpleAdapter.ViewBinder(Adapp),Toast.LENGTH_SHORT).show()
//            getItemViewType(R.id.text_1).toString()
//            Toast.makeText(applicationContext,list.get(position)["First"],Toast.LENGTH_SHORT).show()
            var showListVIew = ShowListVIew()
            val bundle = Bundle()
            bundle.putString("Name", list[position]["First"])
            bundle.putString("Email", list[position]["Second"])
            showListVIew.arguments = bundle
            showListVIew.show(supportFragmentManager,"TAG")
        }


    }
}