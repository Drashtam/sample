package com.example.sugar

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.Id

@Entity(nameInDb = "todo_items")
class TodoItem {
    @Id(autoincrement = true)
    var id: Long? = null
    var name: String? = null
    var status = false
    var age: Long? = null

    @Generated(hash = 288712543)
    constructor(id: Long?, name: String?, status: Boolean, age: Long?) {
        this.id = id
        this.name = name
        this.status = status
        this.age = age
    }

    @Generated(hash = 1307818545)
    constructor() {
    }
}