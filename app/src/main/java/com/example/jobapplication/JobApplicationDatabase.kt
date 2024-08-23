package com.example.jobapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [JobApplication::class],
    version = 1
)
abstract class JobApplicationDatabase:RoomDatabase() {
    abstract fun jobapplicationdao(): JobApplicationDao

    companion object {
        @Volatile
        private var INSTANCE: JobApplicationDatabase? = null

        fun getDatabase(context: Context): JobApplicationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JobApplicationDatabase::class.java,
                    "job_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}