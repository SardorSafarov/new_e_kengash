package com.example.e_kengash.network.retrofitBuilder

import com.example.e_kengash.data.constants.Constants.BASE_URL
import com.example.e_kengash.network.api.LoginApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }
}