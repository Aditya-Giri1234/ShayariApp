package com.aditya.shayariapp.data_layer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aditya.shayariapp.data_layer.util.Constants


@Entity(tableName = Constants.AllShayariCategory)
data class AllShayariCategoryDTO (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constants.uid) val id:Int?,
    @ColumnInfo(name = Constants.name) val name:String?,
    @ColumnInfo(name=Constants.id) val categoryId:Int?
)