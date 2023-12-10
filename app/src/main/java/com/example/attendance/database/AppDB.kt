package com.example.attendance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.attendance.database.classroom.ClassDao
import com.example.attendance.database.classroom.ClassRoom
import com.example.attendance.database.school.School
import com.example.attendance.database.school.SchoolDao
import com.example.attendance.database.student.Student
import com.example.attendance.database.student.StudentDao
import com.example.attendance.database.teacher.Teacher
import com.example.attendance.database.teacher.TeacherDao

@Database(
    entities = [School::class,Teacher::class, Student::class, ClassRoom::class],
    version = 1,
    exportSchema = false
)
abstract class AppDB: RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun teacherDao(): TeacherDao
    abstract fun classRoomDao(): ClassDao
    abstract fun schoolDao(): SchoolDao


    companion object{
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "school_management_db"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}