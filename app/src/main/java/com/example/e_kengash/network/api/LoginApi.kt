package com.example.e_kengash.network.api

import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginApi {

    @POST("api/v1/check-user/")
    suspend fun checkUser(@Body body: CheckUserRequest): Response<CheckUserResponse>

    @POST("/api/v1/register/")
    suspend fun registerUser(@Body body: RegisterUserRequest): Response<RegisterUserResponse>


    @POST("/api/v1/login/")
    suspend fun signIn(@Body body: SignInRequest): Response<SignInResponse>
}
