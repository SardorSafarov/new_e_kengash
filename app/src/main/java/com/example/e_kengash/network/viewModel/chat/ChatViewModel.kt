package com.example.e_kengash.network.viewModel.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.chat.ChatSendMessageRequest
import com.example.e_kengash.network.entity.chat.ChatSendMessageResponse
import com.example.e_kengash.network.repository.chat.ChatRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class ChatViewModel(private val chatRepository: ChatRepository):ViewModel() {

    fun sendMessage(token:String, body: ChatSendMessageRequest, onResponse: (response: Response<ChatSendMessageResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(chatRepository.sendMessage(token,body))
            }catch (e:Exception)
            {
                D("LoginViewModel checkUser  ${e.message}")
            }
        }
    }
}