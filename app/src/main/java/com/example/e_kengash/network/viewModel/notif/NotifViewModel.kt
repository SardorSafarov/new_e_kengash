package com.example.e_kengash.network.viewModel.notif

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.notif.NotificationResponse
import com.example.e_kengash.network.repository.notif.NotificationRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class NotifViewModel(private val notificationRepository: NotificationRepository):ViewModel() {

    fun notif(token:String,onResponse: (response: Response<NotificationResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(notificationRepository.notif(token))
            }catch (e:Exception)
            {
                D("NotifViewModel notif  ${e.message}")
            }
        }
    }
}