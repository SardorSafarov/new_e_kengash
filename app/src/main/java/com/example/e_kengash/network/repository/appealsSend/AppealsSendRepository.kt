package com.example.e_kengash.network.repository.appealsSend

import com.example.e_kengash.network.entity.appealsSend.type.AppealsSendTypeResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class AppealsSendRepository {

    suspend fun appealsType(): Response<AppealsSendTypeResponse> = RetrofitBuilder().appealsSendApi.appealsType()
}