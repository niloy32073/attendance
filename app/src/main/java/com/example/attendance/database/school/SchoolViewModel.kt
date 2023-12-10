package com.example.attendance.database.school

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.attendance.database.AppDB
import kotlinx.coroutines.launch

class SchoolViewModel(application: Application): AndroidViewModel(application) {
    val allSchool: LiveData<List<School>>
    private val SchoolRepository: SchoolRepository
    init {
        val SchoolDao = AppDB.getInstance(application).schoolDao()
        SchoolRepository = SchoolRepository(SchoolDao)
        allSchool = SchoolRepository.allSchool
    }

    fun inserSchool(school: School){
        viewModelScope.launch { SchoolRepository.insertSchool(school) }
    }
    fun deleteSchool(school: School){
        viewModelScope.launch { SchoolRepository.deleteSchool(school) }
    }
    fun updateSchool(school: School){
        viewModelScope.launch { SchoolRepository.updateSchool(school) }
    }
}