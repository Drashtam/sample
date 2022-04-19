package com.example.mvvma

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Model : ViewModel() {
    var username : String ?= null
    var password : String ?= null

    var refence = FirebaseDatabase.getInstance().reference.child("Users")

    fun onSignUp(view : View){
        if(username.isNullOrEmpty() || password.isNullOrEmpty()){
            Toast.makeText(view.context, "Enter Field First", Toast.LENGTH_SHORT).show()
            return
        }
        else{
            var map : HashMap<String,String> = HashMap()
            map.put("Username", username!!)
            map.put("Password",password!!)
            FirebaseDatabase.getInstance().reference.child("Users").push()
                .setValue(map)
            Toast.makeText(view.context, "Data Inserted", Toast.LENGTH_SHORT).show()
            return
        }
    }

    fun onLoginUp(view : View){
        if(username.isNullOrEmpty() || password.isNullOrEmpty()){
            Toast.makeText(view.context, "Enter Field First", Toast.LENGTH_SHORT).show()
            return
        }
        else{
            FirebaseDatabase.getInstance().getReference("Users").addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        for (shot : DataSnapshot in snapshot.children){
                            if(shot.child("Username").exists() && shot.child("Password").exists()){
                                if(shot.child("Username").getValue(String::class.java).equals(username) &&
                                        shot.child("Password").getValue(String::class.java).equals(password)){
                                    if(shot.exists()){
                                        Toast.makeText(view.context,"Hello user $username",Toast.LENGTH_SHORT).show()
                                        break
                                    }
                                }
                            }
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        }
    }
}
