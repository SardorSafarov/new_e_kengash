package com.example.e_kengash.network.repository

import com.example.e_kengash.network.entity.login.CheckUserRequest
import com.example.e_kengash.network.entity.login.CheckUserResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class LoginRepository {

    suspend fun checkUser(tel:CheckUserRequest): Response<CheckUserResponse> = RetrofitBuilder().loginApi.checkUser(tel)
}