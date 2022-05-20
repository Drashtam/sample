package com.example.sugar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class TodoItemAdapter(var todoItemList: List<TodoItem>) :
    RecyclerView.Adapter<TodoItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.item_row, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val todoItem = todoItemList[position]
        holder.textView.text = todoItem.name
        holder.constraintLayout.setOnClickListener { view ->
            Toast.makeText(
                view.context,
                todoItem.name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return todoItemList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView
        var constraintLayout: ConstraintLayout

        init {
            textView = view.findViewById<View>(R.id.labelItemName) as TextView
            constraintLayout = view.findViewById<View>(R.id.item_row_layout) as ConstraintLayout
        }
    }
}