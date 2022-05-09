package com.example.e_kengash.network.api.appealsSend

import com.example.e_kengash.network.entity.appealsSend.type.AppealsSendTypeResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppealsSendApi {
    @GET("/api/v1/appeal-types/")
    suspend fun appealsType():Response<AppealsSendTypeResponse>
}