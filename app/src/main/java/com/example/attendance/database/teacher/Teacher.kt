package com.example.attendance.database.teacher

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher_table")
data class Teacher(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("role") var role: String,
    @ColumnInfo("school_id") val schoolId: Int,
    @ColumnInfo("email") var email: String,
    @ColumnInfo("password") var password: String
){

}
