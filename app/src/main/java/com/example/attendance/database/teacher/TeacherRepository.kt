package com.example.attendance.database.teacher

import androidx.lifecycle.LiveData

class TeacherRepository(
    private val teacherDao: TeacherDao
) {
    val allTeacher: LiveData<List<Teacher>> = teacherDao.getAll()

    suspend fun insertTeacher(teacher: Teacher){
        teacherDao.insert(teacher)
    }
    suspend fun deleteTeacher(teacher: Teacher){
        teacherDao.delete(teacher)
    }
    suspend fun updateTeacher(teacher: Teacher){
        teacherDao.update(teacher)
    }
}