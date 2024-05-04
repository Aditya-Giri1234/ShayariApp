package com.aditya.shayariapp.ui_layer.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.aditya.shayariapp.data_layer.model.AllShayariCategoryDTO
import com.aditya.shayariapp.data_layer.service.ShayariRepo

class ShayariViewModel(val app : Application) : AndroidViewModel(app) {

    lateinit var shayariRepo:ShayariRepo
    val shayariAllCategory= mutableListOf<AllShayariCategoryDTO>()

    init {
        shayariRepo=ShayariRepo(app)
        shayariAllCategory.addAll(shayariRepo.getAllShayariCategory())
    }

    fun getShayariById(id: Int) =shayariRepo.getAllShayariById(id)
}