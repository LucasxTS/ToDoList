package com.example.todolist.ui.features.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.commons.persistence.DeviceIdManager
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MainRepository, context: Context) : ViewModel() {

    val liveData = MutableLiveData<List<TaskModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllData(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val request = repository.getAllData(DeviceIdManager.getDeviceId(context))
            if(request.isSuccessful) {
                val newList = filterTasksById(request.body(), context)
                liveData.postValue(newList)
                println(request.body())
                println(newList)
            }
            errorMessage.postValue(errorMessage.toString())
        }
    }

    init {
        if (isFirstRun(context)) {
            val deviceId = DeviceIdManager.generateDeviceId()
            DeviceIdManager.saveDeviceId(context, deviceId)
            changeFirstRunToFalse(context)
        }
    }

   private fun isFirstRun(context: Context): Boolean {
       val sharedPreferences = context.getSharedPreferences("deviceId", Context.MODE_PRIVATE)
       return sharedPreferences.getBoolean("firstRun", true)
   }

    private fun changeFirstRunToFalse(context: Context) {
        val sharedPreferences = context.getSharedPreferences("deviceId", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("firstRun", false)
        editor.apply()
    }

    private fun filterTasksById(taskList: List<TaskModel>?, context: Context): List<TaskModel> {
        val deviceId = DeviceIdManager.getDeviceId(context)
        if (taskList != null) {
            return taskList.filter { it.deviceId == deviceId }
        }
        return emptyList()
    }
}


