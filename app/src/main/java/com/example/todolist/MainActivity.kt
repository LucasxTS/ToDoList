package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.commons.navigation.route.FlowView
import com.example.todolist.network.RetrofitService
import com.example.todolist.repositories.MainRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()
            val retrofitService = RetrofitService.getInstance()
            FlowView(navController = navController, repository = MainRepository(retrofitService))
        }
    }
}