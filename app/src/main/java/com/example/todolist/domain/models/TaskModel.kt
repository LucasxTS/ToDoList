package com.example.todolist.domain.models
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TaskModel(
    val description: String,
    val completed: Boolean,
   @SerializedName("device_id") val deviceId: String
)

