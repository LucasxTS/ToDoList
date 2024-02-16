package com.example.todolist.ui.features.home

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.commons.persistence.DeviceIdManager
import com.example.todolist.repositories.MainRepository
import com.example.todolist.ui.components.HeaderView
import com.example.todolist.ui.components.InsertTaskView

@Composable
fun HomeScreen(repository: MainRepository, context: Context) {
    val viewModel: HomeViewModel = viewModel( factory = HomeViewModelFactory(repository, context))
    LaunchedEffect(Unit) {
        viewModel.getAllData(context)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderView()
        InsertTaskView()

    }
}




@Preview
@Composable
fun HomeScreenPrev() {
    
}