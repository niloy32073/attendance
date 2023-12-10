package com.example.attendance.database.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("class_id") var classId: Int,
    @ColumnInfo("school_id") var schoolId: Int,
    @ColumnInfo("present") var present: Int,
    @ColumnInfo("absent") var absent: Int
)