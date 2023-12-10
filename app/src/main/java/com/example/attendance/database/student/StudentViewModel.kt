package com.example.attendance.database.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.attendance.database.AppDB
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {
    val allStudent: LiveData<List<Student>>
    private val studentRepository: StudentRepository
    init {
        val studentDao = AppDB.getInstance(application).studentDao()
        studentRepository = StudentRepository(studentDao)
        allStudent = studentRepository.allStudent
    }

    fun inserStudent(student: Student){
        viewModelScope.launch { studentRepository.insertStudent(student) }
    }
    fun deleteStudent(student: Student){
        viewModelScope.launch { studentRepository.deleteStudent(student) }
    }
    fun updateStudent(student: Student){
        viewModelScope.launch { studentRepository.updateStudent(student) }
    }
}