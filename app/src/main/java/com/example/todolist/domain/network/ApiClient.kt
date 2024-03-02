package com.example.todolist.domain.network

import com.example.todolist.domain.models.TaskModel
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {

    @GET("todos")
    suspend fun getTasks(@Query("device_id") deviceId: String?): Response<List<TaskModel>>

    @POST("todos")
    suspend fun createTask(@Body bodyTask: TaskModel): Response<ResponseBody>

    companion object {
        private val baseUrl = "https://tower-todolist.onrender.com/"

        fun getInstance(): RetrofitService {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }
}
