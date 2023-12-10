package com.example.attendance.database.classroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ClassDao {
    @Query("SELECT * FROM classroom_table")
    fun getAll(): LiveData<List<ClassRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(classroom: ClassRoom)

    @Delete
    suspend fun delete(classroom: ClassRoom)

    @Update
    suspend fun update(classroom: ClassRoom)
}