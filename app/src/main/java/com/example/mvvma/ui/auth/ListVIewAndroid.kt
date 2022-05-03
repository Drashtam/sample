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
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class ListVIewAndroid : AppCompatActivity() {
    lateinit var binding : ActivityListViewAndroidBinding

    var array = arrayListOf<HashMap<String,String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Toast.makeText(applicationContext,"Activity Created",Toast.LENGTH_SHORT).show()
//        setContentView(R.layout.activity_list_view_android)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view_android)
        val viewModel5 = ViewModelProvider(this).get(Model4::class.java)
        binding.viewModel5 = viewModel5
        load_JSON()

//
//        val hashMap = HashMap<String,String>()
//        hashMap.put("agapow","agapow@aol.com")
//        hashMap.put("lbaxter","lbaxter@yahoo.com")
//        hashMap.put("mmccool","mmccool@att.net")
//        hashMap.put("dmiller","dmiller@outlook.com")
//        hashMap.put("burniske","burniske@optonline.net")
//        hashMap.put("stevelim","stevelim@outlook.com")
//        hashMap.put("wayward","wayward@icloud.com")
//        hashMap.put("adillon","adillon@gmail.com")
//        hashMap.put("grolschie","grolschie@yahoo.com")
//        hashMap.put("gmcgath", "gmcgath@me.com")
//        hashMap.put("camenisch", "camenisch@msn.com")
//        hashMap.put("thrymm","thrymm@att.net")
//
//
//        var list = ArrayList<HashMap<String,String>>()
//        val string = arrayOf("First","Second")
//        val intArr = arrayOf(R.id.text_1,R.id.text_2)
//        var simpleAdapter : SimpleAdapter = SimpleAdapter(this,list,R.layout.items,string,intArr.toIntArray())
//
//        val iterator = hashMap.entries.iterator()
//
//        while (iterator.hasNext()){
//            val map = HashMap<String,String>()
//            val pair = iterator.next()
//            map.put("First",pair.key)
//            map.put("Second",pair.value)
//            list.add(map)
//
//        }
//        binding.listview.adapter = simpleAdapter
//
//        binding.listview.setOnItemClickListener { adapterView : AdapterView<*>, view : View, position : Int, id : Long ->
//            val intent = Intent(applicationContext,ShowListVIew::class.java)
//            var showListVIew = ShowListVIew()
//            val bundle = Bundle()
//            bundle.putString("Name", list[position]["First"])
//            bundle.putString("Email", list[position]["Second"])
//            showListVIew.arguments = bundle
//            showListVIew.show(supportFragmentManager,"TAG")
//        }


    }

    fun load_JSON() : String? {
        var json : String ?= null
        try {
            val inputStream: InputStream = assets.open("Sample.json")

            json = inputStream.bufferedReader().use { (it.readText()) }

            val arrayJSON = JSONArray(json)

            inputStream.close()

            for (i in 0..arrayJSON.length() - 1) {

                val objJSONArray = arrayJSON.getJSONObject(i)

                val hasHMap = HashMap<String, String>()

                hasHMap.put(
                    objJSONArray.getString("name"),
                    objJSONArray.getString("email")
                )

                val STR = arrayOf("First", "Second")
                val IntArr = arrayOf(R.id.text_1, R.id.text_2)
                val sampleAdapter: SimpleAdapter =
                    SimpleAdapter(this, array, R.layout.items, STR, IntArr.toIntArray())

                val aIterator = hasHMap.entries.iterator()
//
//              while (aIterator.hasNext()) {
                val map = HashMap<String, String>()
                val pair = aIterator.next()
                map.put("First", pair.key)
                map.put("Second", pair.value)
                array.add(map)

//                }
                binding.listview.adapter = sampleAdapter
                binding.listview.setOnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
                    var showListVIew = ShowListVIew()
                    val bundle = Bundle()
                    bundle.putString("Name", array[position]["First"])
                    bundle.putString("Email", array[position]["Second"])
                    showListVIew.arguments = bundle
                    showListVIew.show(supportFragmentManager,"TAG")

                }
            }
        }
        catch (e : IOException){
            Toast.makeText(applicationContext,e.message,Toast.LENGTH_SHORT).show()
        }
        return json
    }

}