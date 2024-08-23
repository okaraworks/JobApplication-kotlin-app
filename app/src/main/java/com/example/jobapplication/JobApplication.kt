package com.example.jobapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobapplicationtbl")
data class JobApplication(

    val companyName:String,
    val position:String,
    val status:String,
    val interViewDate:String?=null,
    val followUpDate:String?=null,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0

)
