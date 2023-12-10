package com.example.attendance.database.school

import androidx.lifecycle.LiveData

class SchoolRepository(
private val schoolDao: SchoolDao
) {
    val allSchool: LiveData<List<School>> = schoolDao.getAll()
    suspend fun insertSchool(school: School){
        schoolDao.insert(school)
    }
    suspend fun deleteSchool(school: School){
        schoolDao.delete(school)
    }
    suspend fun updateSchool(school: School){
        schoolDao.update(school)
    }
}