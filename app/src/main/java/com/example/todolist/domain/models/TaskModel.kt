package com.example.todolist.domain.models
import com.google.gson.annotations.SerializedName


data class TaskModel(
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("completed") val completed: Boolean,
    @SerializedName("device_id") val deviceId: String
)

