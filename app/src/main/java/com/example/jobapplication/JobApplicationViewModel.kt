package com.example.jobapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JobApplicationViewModel(private val repository: JobApplicationRepository) : ViewModel() {

    private val _allJobs = MutableLiveData<List<JobApplication>>()
    val allJobs: MutableLiveData<List<JobApplication>> get() = _allJobs

    init {
        viewModelScope.launch {
            _allJobs.value = repository.getAllJobs()
        }
    }

    fun addApplication(jobApplication: JobApplication) {
        viewModelScope.launch {
            repository.insertJobApplication(jobApplication)
            _allJobs.value = repository.getAllJobs() // Update LiveData after insertion
        }
    }

    fun delApplication(jobApplication: JobApplication) {
        viewModelScope.launch {
            repository.delJobApplication(jobApplication)
            _allJobs.value = repository.getAllJobs() // Update LiveData after deletion
        }
    }
}
