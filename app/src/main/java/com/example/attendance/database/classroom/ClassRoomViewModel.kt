package com.example.attendance.database.classroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.attendance.database.AppDB
import kotlinx.coroutines.launch

class ClassViewModel(application: Application): AndroidViewModel(application) {
    val allclass: LiveData<List<ClassRoom>>
    private val classRepository: ClassRepository
    init {
        val classDao = AppDB.getInstance(application).classRoomDao()
        classRepository = ClassRepository(classDao)
        allclass = classRepository.allClassRoom
    }

    fun inserclass(classRoom: ClassRoom){
        viewModelScope.launch { classRepository.insertClass(classRoom) }
    }
    fun deleteclass(classRoom: ClassRoom){
        viewModelScope.launch { classRepository.deleteClass(classRoom) }
    }
    fun updateclass(classRoom: ClassRoom){
        viewModelScope.launch { classRepository.updateClass(classRoom) }
    }
}