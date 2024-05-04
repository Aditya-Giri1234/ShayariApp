package com.aditya.shayariapp.data_layer.db

import android.content.Context
import androidx.room.Room
import com.aditya.shayariapp.data_layer.util.Constants

object DbBuilder {

    private var INSTANCE:ShayariDatabase?=null

    fun getDatabase(context: Context):ShayariDatabase{
        if (INSTANCE==null){
            INSTANCE=Room.databaseBuilder(context, ShayariDatabase::class.java,Constants.databaseName).fallbackToDestructiveMigration().allowMainThreadQueries().createFromAsset(Constants.databaseName).build()
        }
        return INSTANCE!!
    }

}