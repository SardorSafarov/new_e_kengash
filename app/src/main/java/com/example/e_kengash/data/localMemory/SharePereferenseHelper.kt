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

    fun setAccessFirsName(phone: String) {
        editor = preferences.edit()
        editor.putString(FIRST_NAME, phone)
        editor.apply()
    }

    fun getAccessFirstName() = preferences.getString(FIRST_NAME, "empty").toString()

    fun setAccessLastName(phone: String) {
        editor = preferences.edit()
        editor.putString(LAST_NAME, phone)
        editor.apply()
    }

    fun getAccessLastName() = preferences.getString(LAST_NAME, "empty").toString()

    fun setAccessMidelName(phone: String) {
        editor = preferences.edit()
        editor.putString(MIDEL_NAME, phone)
        editor.apply()
    }

    fun getAccessMidelName() = preferences.getString(MIDEL_NAME, "empty").toString()

    fun setAccessPassword1(phone: String) {
        editor = preferences.edit()
        editor.putString(PASSWORD1, phone)
        editor.apply()
    }

    fun getAccessPassword1() = preferences.getString(PASSWORD1, "empty").toString()

    fun setAccessPassword2(phone: String) {
        editor = preferences.edit()
        editor.putString(PASSWORD2, phone)
        editor.apply()
    }

    fun getAccessPassword2() = preferences.getString(PASSWORD2, "empty").toString()
}