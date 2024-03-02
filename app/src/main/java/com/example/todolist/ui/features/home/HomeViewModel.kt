package com.example.todolist.ui.features.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.commons.persistence.DeviceIdManager
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.network.RetrofitService
import com.example.todolist.domain.network.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(context: Context) : ViewModel() {

    var tasksLiveData = MutableLiveData<List<TaskModel>>()
    private val errorMessage = MutableLiveData<String>()
    private val repository = MainRepository(RetrofitService.getInstance())

    init {
        val deviceId = DeviceIdManager.getDeviceId(context)
        println(deviceId)
        if (deviceId == null) {
            val newDeviceId = DeviceIdManager.generateDeviceId()
            DeviceIdManager.saveDeviceId(context, newDeviceId)
        }
    }

    fun getAllData(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = repository.getAllData(DeviceIdManager.getDeviceId(context))
                if (request.isSuccessful) {
                    tasksLiveData.postValue(request.body())
                }
                errorMessage.postValue(errorMessage.toString())
            } catch (e: Exception) {
                errorMessage.postValue("Timeout occurred: ${e.message}")
            }
        }
    }



    fun createNewTask(task: TaskModel, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = repository.creatingNewTask(task)
                if (request.isSuccessful) {
                    println("200 code")
                    getAllData(context)
                }
            } catch (e: Exception) {
             println(e)
            }
        }
    }
}


