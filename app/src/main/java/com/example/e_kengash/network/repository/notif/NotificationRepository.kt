package com.example.e_kengash.network.repository.notif

import com.example.e_kengash.network.entity.notif.NotificationResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import com.example.e_kengash.repetitive.D
import retrofit2.Response

class NotificationRepository {
    suspend fun notif(token:String):Response<NotificationResponse> {
        D(token)
        return RetrofitBuilder().notificationApi.notif(token)
    }
}