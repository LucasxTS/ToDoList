package com.example.todolist.ui.features.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.repositories.MainRepository


class HomeViewModelFactory(private val repository: MainRepository,private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.repository, this.context) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
