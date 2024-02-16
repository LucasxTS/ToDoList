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
}


