package com.example.e_kengash.network.viewModelFactory.notif

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.notif.NotificationRepository
import com.example.e_kengash.network.viewModel.notif.NotifViewModel

class NotifViewModelFactory(private val notificationRepository: NotificationRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotifViewModel(notificationRepository) as T
    }
}