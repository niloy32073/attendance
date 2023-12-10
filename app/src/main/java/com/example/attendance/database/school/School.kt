package com.example.attendance.database.school

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school_table")
data class School(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("EIIN") var EIIN: Int
){
}
