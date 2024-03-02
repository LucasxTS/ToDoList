package com.example.todolist.ui.features.home

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.components.HeaderView
import com.example.todolist.ui.components.InsertTaskView
import com.example.todolist.ui.components.ToDoListView

@Composable
fun HomeScreen(context: Context) {
    val viewModel = HomeViewModel(context)
    LaunchedEffect(Unit) {
        viewModel.getAllData(context)
    }
    val taskList by viewModel.tasksLiveData.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderView()
        InsertTaskView(viewModel, context)
        ToDoListView(taskList = taskList.reversed())
    }
}

@Preview
@Composable
fun HomeScreenPrev() {
    
}