package com.example.jobapplication

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface JobApplicationDao {
    @Query("SELECT * FROM jobapplicationtbl")
    fun getAllApplications(): List<JobApplication>
    @Query("SELECT * FROM jobapplicationtbl WHERE id=:id")
    suspend fun getApplication(id:Int):JobApplication
    @Delete
    suspend fun delApplication(jobApplication: JobApplication)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApplication(jobApplication: JobApplication)
}