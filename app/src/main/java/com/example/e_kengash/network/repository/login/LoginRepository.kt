package com.example.e_kengash.network.repository.login

import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import com.example.e_kengash.network.entity.login.sms.sendPhone.SendPhoneResponse
import com.example.e_kengash.network.entity.login.sms.sendSms.CheckSmsRequest
import com.example.e_kengash.network.entity.login.sms.sendSms.CheckSmsResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import com.example.e_kengash.repetitive.RequestLog
import retrofit2.Response

class LoginRepository {

    suspend fun checkUser(tel: CheckUserRequest): Response<CheckUserResponse> = RetrofitBuilder().loginApi.checkUser(tel)

    suspend fun registerUser(request: RegisterUserRequest): Response<RegisterUserResponse> = RetrofitBuilder().loginApi.registerUser(request)

    suspend fun signIn(request: SignInRequest): Response<SignInResponse> {
        RequestLog(request.toString(),"LoginRepository signIn")
    return RetrofitBuilder().loginApi.signIn(request)
    }

    suspend fun sendPhone(request: String): Response<SendPhoneResponse> = RetrofitBuilder().loginApi.sendPhone(request)

    suspend fun checkSms(request: CheckSmsRequest): Response<CheckSmsResponse> = RetrofitBuilder().loginApi.checkSms(request)
}