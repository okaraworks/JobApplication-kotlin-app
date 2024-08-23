package com.example.jobapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JobApplicationViewModelFactory(private val repository: JobApplicationRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JobApplicationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return JobApplicationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}