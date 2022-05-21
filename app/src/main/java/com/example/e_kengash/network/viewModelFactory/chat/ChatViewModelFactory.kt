package com.example.e_kengash.network.viewModelFactory.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.chat.ChatRepository
import com.example.e_kengash.network.viewModel.chat.ChatViewModel


class ChatViewModelFactory(private val chatRepository: ChatRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatViewModel(chatRepository) as T
    }
}