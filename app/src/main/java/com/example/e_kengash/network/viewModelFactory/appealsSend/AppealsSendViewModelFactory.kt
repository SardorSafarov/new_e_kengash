package com.example.e_kengash.network.viewModelFactory.appealsSend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.appealsSend.AppealsSendRepository
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.appealsSend.AppealsSendViewModel
import com.example.e_kengash.network.viewModel.login.LoginViewModel




class AppealsSendViewModelFactory(private val appealsSendRepository: AppealsSendRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppealsSendViewModel(appealsSendRepository) as T
    }
}