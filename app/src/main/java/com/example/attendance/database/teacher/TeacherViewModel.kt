package com.example.attendance.database.teacher

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.attendance.database.AppDB
import kotlinx.coroutines.launch

class TeacherViewModel(application: Application): AndroidViewModel(application) {
    val allTeacher: LiveData<List<Teacher>>
    private val TeacherRepository: TeacherRepository
    init {
        val TeacherDao = AppDB.getInstance(application).teacherDao()
        TeacherRepository = TeacherRepository(TeacherDao)
        allTeacher = TeacherRepository.allTeacher
    }

    fun inserTeacher(teacher: Teacher){
        viewModelScope.launch { TeacherRepository.insertTeacher(teacher) }
    }
    fun deleteTeacher(teacher: Teacher){
        viewModelScope.launch { TeacherRepository.deleteTeacher(teacher) }
    }
    fun updateTeacher(teacher: Teacher){
        viewModelScope.launch { TeacherRepository.updateTeacher(teacher) }
    }
}