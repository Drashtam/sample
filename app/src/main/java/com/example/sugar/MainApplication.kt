package com.example.sugar

import android.app.Application
import org.greenrobot.greendao.database.Database

class MainApplication : Application() {

    private lateinit var daoSession : DaoSession

    override fun onCreate() {
        super.onCreate()

        var helper : DaoMaster.DevOpenHelper = DaoMaster.DevOpenHelper(this,"remind_me",null)

        var db : Database = helper.writableDb

        daoSession = DaoMaster(db).newSession()


    }
    fun getDaoSession() : DaoSession{
        return daoSession
    }
}