package com.example.todolist.domain.network.repositories

import android.content.Context
import com.example.todolist.domain.models.TaskModel
import com.example.todolist.domain.network.RetrofitService
import okhttp3.ResponseBody
import retrofit2.Response

class MainRepository(private val retrofitService: RetrofitService) {
     suspend fun getAllData(deviceId: String?) : Response<List<TaskModel>> {
        return retrofitService.getTasks(deviceId)
     }

    suspend fun creatingNewTask(newTask: TaskModel) : Response<ResponseBody> {
        return retrofitService.createTask(newTask)
    }
}