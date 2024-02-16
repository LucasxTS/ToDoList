package com.example.todolist.commons.persistence

import android.content.Context
import java.util.UUID

object DeviceIdManager {

    fun generateDeviceId(): String {
        return UUID.randomUUID().toString()
    }

    fun saveDeviceId(context: Context, deviceId: String) {
        val sharedPreferences = context.getSharedPreferences("deviceId", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("deviceId", deviceId)
        editor.apply()
    }

    fun getDeviceId(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("deviceId", Context.MODE_PRIVATE)
        return sharedPreferences.getString("deviceId", null)
    }
}