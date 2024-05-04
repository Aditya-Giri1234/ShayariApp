package com.aditya.shayariapp.data_layer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aditya.shayariapp.data_layer.util.Constants


@Entity(tableName = Constants.AllShayari)
data class AllShayariDTO(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constants.uid) val id:Int?,
    @ColumnInfo(name = Constants.Cat_id) val categoryId:Int ?,
    @ColumnInfo(name = Constants.Shayari)val shayari:String?
)
