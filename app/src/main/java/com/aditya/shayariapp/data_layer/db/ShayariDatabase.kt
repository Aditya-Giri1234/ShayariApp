package com.aditya.shayariapp.data_layer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aditya.shayariapp.data_layer.model.AllShayariCategoryDTO
import com.aditya.shayariapp.data_layer.model.AllShayariDTO
import com.aditya.shayariapp.data_layer.service.ShayariDao

@Database(entities = [AllShayariCategoryDTO::class, AllShayariDTO::class] , version = 3 , exportSchema = false)
abstract class ShayariDatabase : RoomDatabase() {
    abstract fun getDao():ShayariDao
}