package com.example.attendance.database.student

import androidx.lifecycle.LiveData

class StudentRepository(
    private val studentDao: StudentDao
) {
    val allStudent: LiveData<List<Student>> = studentDao.getAll()

    suspend fun insertStudent(student: Student){
        studentDao.insert(student)
    }
    suspend fun deleteStudent(student: Student){
        studentDao.delete(student)
    }
    suspend fun updateStudent(student: Student){
        studentDao.update(student)
    }
}