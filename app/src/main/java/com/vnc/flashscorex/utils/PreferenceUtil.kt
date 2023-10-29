package com.vnc.flashscorex.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    // Store a string value in shared preferences
    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    // Get a string value from shared preferences
    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    // Store an int value in shared preferences
    fun saveInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    // Get an int value from shared preferences
    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    // Store a boolean value in shared preferences
    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    // Get a boolean value from shared preferences
    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    // Clear all the saved preferences
    fun clearPreferences() {
        sharedPreferences.edit().clear().apply()
    }
}
