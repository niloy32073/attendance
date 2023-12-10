package com.example.attendance.database.teacher

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TeacherDao {
    @Query("SELECT * FROM teacher_table")
    fun getAll(): LiveData<List<Teacher>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teacher: Teacher)

    @Delete
    suspend fun delete(teacher: Teacher)

    @Update
    suspend fun update(teacher: Teacher)
}