package com.example.e_kengash.network.api

import com.example.e_kengash.network.entity.login.CheckUserRequest
import com.example.e_kengash.network.entity.login.CheckUserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginApi {

    @POST("/api/v1/sign-up")
    suspend fun checkUser(@Body body: CheckUserRequest): Response<CheckUserResponse>
}
