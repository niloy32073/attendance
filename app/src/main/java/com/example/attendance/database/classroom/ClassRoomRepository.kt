package com.example.attendance.database.classroom

import androidx.lifecycle.LiveData

class ClassRepository(
    private val classDao: ClassDao
) {
    val allClassRoom: LiveData<List<ClassRoom>> = classDao.getAll()

    suspend fun insertClass(classRoom: ClassRoom){
        classDao.insert(classRoom)
    }
    suspend fun deleteClass(classRoom: ClassRoom){
        classDao.delete(classRoom)
    }
    suspend fun updateClass(classRoom: ClassRoom){
        classDao.update(classRoom)
    }
}