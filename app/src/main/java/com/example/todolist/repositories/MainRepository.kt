package com.example.todolist.repositories

import com.example.todolist.domain.models.TaskModel
import com.example.todolist.network.RetrofitService
import retrofit2.Response

class MainRepository(private val retrofitService: RetrofitService) {

     suspend fun getAllData() : Response<List<TaskModel>> {
        return retrofitService.getTasks()
     }
}