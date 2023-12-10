package com.example.attendance.database.classroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classroom_table")
data class ClassRoom(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo("name") var name:String,
    @ColumnInfo("teacher_id") var teacherId: Int,
    @ColumnInfo("school_id") var schoolId: Int
){

}
