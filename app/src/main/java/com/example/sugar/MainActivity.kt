package com.example.sugar

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sugar.data.remote.PostsService
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private val service by lazy { PostsService.create() }

    lateinit var todoItemDao : TodoItemDao
    lateinit var todoItemList: List<TodoItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val daoSession : DaoSession = (application as MainApplication).getDaoSession()

        todoItemDao = daoSession.todoItemDao

        if(todoItemDao.queryBuilder().count() == 0L){

            val todoItem = TodoItem()
            todoItem.name = "DataBase"
            todoItem.status = true
            todoItem.age = 20
            todoItemDao.save(todoItem)

        }

        val rvItems : RecyclerView = findViewById(R.id.rvItems)

        todoItemList = todoItemDao.queryBuilder().list()

        val todoItemAdapter : TodoItemAdapter = TodoItemAdapter(todoItemList)

        rvItems.adapter = todoItemAdapter

        rvItems.layoutManager = LinearLayoutManager(applicationContext)

        val fab : FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener{
            val builder : AlertDialog.Builder = AlertDialog.Builder(this)

            val customLayout : View = layoutInflater.inflate(R.layout.dialog_layout,null)

            builder.setView(customLayout)
            builder.setTitle("Add Item")
                .setPositiveButton("Save") { dialogInterface, i ->
                    val txtName = customLayout.findViewById<EditText>(R.id.edtItemName)
                    val name = txtName.text.toString()
                    val todoItem = TodoItem()
                    todoItem.name = name
                    todoItem.status = false
                    todoItem.age = 20
                    todoItemDao.save(todoItem)
                    finish()
                    overridePendingTransition(0, 0)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Item added", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(
                    "Cancel"
                ) { dialogInterface, i -> }
                .create()
                .show()

        }

    }

//        setContent {
//            val posts = produceState<List<PostResponse>>(
//                initialValue = emptyList(),
//                producer = {
//                    value = service.getPosts()
//                }
//            )

//            KtorClientAndroidTheme
//            KtorClientAndroidTheme{
//                Surface(color = MaterialTheme.colors.background)
//                LazyColumn{
//                    items(posts.value){
//                        androidx.compose.foundation.layout.Column(
//                            modifier = Modifier.fillMaxWidth().padding(16.dp)
//                        ){
//                            Text(text = it.title,fontSize = 20.sp)
//                            Spacer(modifier = Modifier.height(4.dp))
//                            Text(text = it.body, fontSize = 14.sp)
//                        }
//                    }
//                }
//            }
//        }

//        save.setOnClickListener {
//
//            val name = username.text.toString()
//            val age = userage.text.toString()
//            if(name.isNotEmpty() && age.isNotEmpty()) {
//                savePerson(name, age)
//                text()
//            }
//        }
//    }

//    private fun text(){
//        CoroutineScope(Main).launch{
//            username.setText("")
//            userage.setText("")
//        }
//
//    }
//    private fun savePerson(name: String, age: String) {
//        val person = Person(name,age.toInt())
//        person.save()
//    }
//    }
}