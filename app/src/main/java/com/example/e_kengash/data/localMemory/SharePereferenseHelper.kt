package com.example.e_kengash.data.localMemory

import android.content.Context
import android.content.SharedPreferences
import com.example.e_kengash.data.constants.Constants.ACCESS_TOKEN
import com.example.e_kengash.data.constants.Constants.APP_LOCAL_MEMORY
import com.example.e_kengash.data.constants.Constants.FIRST_NAME
import com.example.e_kengash.data.constants.Constants.LAST_NAME
import com.example.e_kengash.data.constants.Constants.MIDEL_NAME
import com.example.e_kengash.data.constants.Constants.PASSWORD1
import com.example.e_kengash.data.constants.Constants.PASSWORD2
import com.example.e_kengash.data.constants.Constants.PHONE

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

    fun setAccessPhone(phone: String) {
        editor = preferences.edit()
        editor.putString(PHONE, phone)
        editor.apply()
    }

    fun getAccessPhone() = preferences.getString(PHONE, "empty").toString()
}