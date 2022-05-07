package com.example.e_kengash.network.repository.notif

import com.example.e_kengash.network.entity.notif.NotificationResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class NotificationRepository {
    suspend fun notif(token:String):Response<NotificationResponse> = RetrofitBuilder().notificationApi.notif(token)
}