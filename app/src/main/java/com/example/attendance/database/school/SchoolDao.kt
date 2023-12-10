package com.example.attendance.database.school

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.attendance.database.teacher.Teacher

@Dao
interface SchoolDao {
    @Query("SELECT * FROM school_table")
    fun getAll(): LiveData<List<School>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(school: School)

    @Delete
    suspend fun delete(school: School)

    @Update
    suspend fun update(school: School)
}