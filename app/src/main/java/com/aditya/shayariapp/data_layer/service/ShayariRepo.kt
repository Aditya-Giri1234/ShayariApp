package com.aditya.shayariapp.data_layer.service

import android.content.Context
import com.aditya.shayariapp.data_layer.db.DbBuilder
import com.aditya.shayariapp.data_layer.db.ShayariDatabase

class ShayariRepo(val context: Context) {
    lateinit var database: ShayariDatabase
    init {
        database=DbBuilder.getDatabase(context)
    }

    fun getAllShayariCategory()=database.getDao().getAllShayariCategory()

    fun  getAllShayariById(id:Int)=database.getDao().getAllShayariById(id)

}