package com.example.todolist.network

import com.example.todolist.domain.models.TaskModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {

    @GET("todos")
    suspend fun getTasks(@Query("device_id") deviceId: String?): Response<List<TaskModel>>


    companion object {
        private val baseUrl = "https://tower-todolist.onrender.com/"

        fun getInstance(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }
}
