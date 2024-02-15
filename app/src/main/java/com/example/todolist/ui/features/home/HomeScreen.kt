package com.example.todolist.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.repositories.MainRepository
import com.example.todolist.ui.components.HeaderView
import com.example.todolist.ui.components.InsertTaskView

@Composable
fun HomeScreen(repository: MainRepository) {
    val viewModel: HomeViewModel = viewModel( factory = HomeViewModelFactory(repository))
    LaunchedEffect(Unit) {
        viewModel.getAllData()
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