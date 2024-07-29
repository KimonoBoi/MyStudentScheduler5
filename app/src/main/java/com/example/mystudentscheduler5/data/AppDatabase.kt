package com.example.mystudentscheduler5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mystudentscheduler5.data.dao.*
import com.example.mystudentscheduler5.data.entities.*

@Database(entities = [Course::class, Assignment::class, CourseAssignmentCrossRef::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun assignmentDao(): AssignmentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "student_scheduler_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
