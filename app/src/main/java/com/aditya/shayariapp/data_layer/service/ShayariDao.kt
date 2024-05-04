package com.aditya.shayariapp.data_layer.service

import androidx.room.Dao
import androidx.room.Query
import com.aditya.shayariapp.data_layer.model.AllShayariCategoryDTO
import com.aditya.shayariapp.data_layer.model.AllShayariDTO
import com.aditya.shayariapp.data_layer.util.Constants


@Dao
interface ShayariDao {

    @Query("select * from AllShayariCategory")
     fun getAllShayariCategory():List<AllShayariCategoryDTO>

    @Query("select * from AllShayari where ${Constants.Cat_id}=:id")
     fun getAllShayariById(id:Int):List<AllShayariDTO>


}