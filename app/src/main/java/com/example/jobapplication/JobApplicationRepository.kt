package com.example.jobapplication

class JobApplicationRepository(private val jobApplicationDao: JobApplicationDao) {

    suspend fun getAllJobs(): List<JobApplication> {
        return jobApplicationDao.getAllApplications()
    }

    suspend fun insertJobApplication(jobApplication: JobApplication) {
        jobApplicationDao.insertApplication(jobApplication)
    }

    suspend fun delJobApplication(jobApplication: JobApplication) {
        jobApplicationDao.delApplication(jobApplication)
    }
}
