package com.example.e_kengash.network.repository.chat

import com.example.e_kengash.network.entity.chat.ChatSendMessageRequest
import com.example.e_kengash.network.entity.chat.ChatSendMessageResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class ChatRepository {
    suspend fun sendMessage(token:String,body:ChatSendMessageRequest):Response<ChatSendMessageResponse> = RetrofitBuilder().chatApi.sendMessage(token,body)
}