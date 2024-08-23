package com.example.jobapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.*
import androidx.compose.runtime.Composable


@Composable
fun JobApplicationTracker(viewModel: JobApplicationViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {

        JobApplicationList(jobApplications = viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        AddJobApplicationForm(onAddJobApplication = { jobApplication ->
            viewModel.addApplication(jobApplication)
        })

        Spacer(modifier = Modifier.height(16.dp))

    }

}
@Composable
fun JobApplicationList(jobApplications: JobApplicationViewModel) {
    val myjobs= remember {
        mutableStateListOf<JobApplication>()
    }
    LazyColumn {
        items(myjobs.size) { index ->
            val jobApplication = myjobs[index]
            JobApplicationItem(jobApplication)
        }
    }
}

@Composable
fun JobApplicationItem(jobApplication: JobApplication) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Company: ${jobApplication.companyName}")
            Text(text = "Position: ${jobApplication.position}")
            Text(text = "Status: ${jobApplication.status}")

        }
    }
}

@Composable
fun AddJobApplicationForm(onAddJobApplication: (JobApplication) -> Unit) {
    var companyName by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Column {
        BasicTextField(
            value = companyName,
            onValueChange = { companyName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .background(MaterialTheme.colorScheme.background)
                         .padding(8.dp)
                ) {
                    if (companyName.isEmpty()) Text("Company Name")
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = position,
            onValueChange = { position = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(8.dp)
                ) {
                    if (position.isEmpty()) Text("Position")
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = status,
            onValueChange = { status = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(8.dp)
                ) {
                    if (status.isEmpty()) Text("Status")
                    innerTextField()
                }
            }
        )
        Button(
            onClick = {
                onAddJobApplication(JobApplication(companyName, position, status))
                companyName = ""
                position = ""
                status = ""
            },
            modifier = Modifier.padding(8.dp)
        ) {

            Text("Add Job Application")
        }
    }
}











