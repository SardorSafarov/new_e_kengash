package com.example.e_kengash.network.repository

import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import com.example.e_kengash.network.entity.login.sms.sendSms.SendSmsResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class LoginRepository {

    suspend fun checkUser(tel: CheckUserRequest): Response<CheckUserResponse> = RetrofitBuilder().loginApi.checkUser(tel)

    suspend fun registerUser(request: RegisterUserRequest): Response<RegisterUserResponse> = RetrofitBuilder().loginApi.registerUser(request)

    suspend fun signIn(request: SignInRequest): Response<SignInResponse> = RetrofitBuilder().loginApi.signIn(request)

    suspend fun sendPhone(request: String): Response<SendSmsResponse> = RetrofitBuilder().loginApi.sendPhone(request)
}