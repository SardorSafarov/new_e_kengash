package com.example.e_kengash.network.api

import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import com.example.e_kengash.network.entity.login.sms.sendSms.SendSmsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface LoginApi {

    @POST("api/v1/check-user/")
    suspend fun checkUser(@Body body: CheckUserRequest): Response<CheckUserResponse>

    @POST("/api/v1/register/")
    suspend fun registerUser(@Body body: RegisterUserRequest): Response<RegisterUserResponse>


    @POST("/api/v1/login/")
    suspend fun signIn(@Body body: SignInRequest): Response<SignInResponse>

    @GET("document/sms-check")
    suspend fun sendPhone(@Query("phone")phone:String):Response<SendSmsResponse>
}
