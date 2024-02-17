package com.example.todolist.commons.navigation.route

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.domain.network.repositories.MainRepository
import com.example.todolist.ui.features.home.HomeScreen

@Composable
fun FlowView(
    navController: NavHostController,
    context: Context
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME.route)
    {
        composable(Routes.HOME.route) {
            HomeScreen(context)
        }
    }
}
