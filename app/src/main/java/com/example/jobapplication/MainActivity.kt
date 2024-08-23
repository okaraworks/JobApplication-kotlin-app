package com.example.jobapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.jobapplication.ui.theme.JobApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = JobApplicationDatabase.getDatabase(this)
        val repository =JobApplicationRepository (database.jobapplicationdao())
        val viewModelFactory = JobApplicationViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(JobApplicationViewModel::class.java)

        setContent {

            JobApplicationTheme {

                    JobApplicationTracker(viewModel)



            }
        }
    }
}

