package com.example.e_kengash.data.localMemory

import android.content.Context
import android.content.SharedPreferences
import com.example.e_kengash.data.constants.Constants.ACCESS_TOKEN
import com.example.e_kengash.data.constants.Constants.APP_LOCAL_MEMORY

class SharePereferenseHelper(val context: Context) {
    private var preferences: SharedPreferences =
        context.getSharedPreferences(APP_LOCAL_MEMORY, Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor
    fun setAccessToken(token: String) {
        editor = preferences.edit()
        editor.putString(ACCESS_TOKEN, token)
        editor.apply()
    }

    fun getAccessToken() = preferences.getString(ACCESS_TOKEN, "empty").toString()
}