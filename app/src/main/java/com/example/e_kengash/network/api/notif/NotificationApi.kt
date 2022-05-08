package com.example.e_kengash.network.api.notif

import com.example.e_kengash.network.entity.notif.NotificationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface NotificationApi {
    @GET("/api/v1/notifaction")
    suspend fun notif(@Header("Authorization")token:String):Response<NotificationResponse>
}