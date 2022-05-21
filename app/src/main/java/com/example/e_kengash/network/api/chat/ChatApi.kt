package com.example.e_kengash.network.api.chat

import com.example.e_kengash.network.entity.chat.ChatSendMessageRequest
import com.example.e_kengash.network.entity.chat.ChatSendMessageResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatApi {

    @POST("/api/v1/ticket-send/")
    suspend fun sendMessage(@Header("Authorization")token:String,@Body body: ChatSendMessageRequest):Response<ChatSendMessageResponse>

}