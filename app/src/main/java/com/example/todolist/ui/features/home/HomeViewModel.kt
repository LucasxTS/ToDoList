package com.example.todolist.ui.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.repositories.MainRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MainRepository) : ViewModel() {

    val liveData = MutableLiveData<List<TaskModel>>()
    val errorMessage = MutableLiveData<String>()

    @OptIn(DelicateCoroutinesApi::class)
    fun getAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            val request = repository.getAllData()
            if(request.isSuccessful) {
                val tasks = request.body()
                println(tasks)
            }
            println(request.toString())
        }
    }
}


