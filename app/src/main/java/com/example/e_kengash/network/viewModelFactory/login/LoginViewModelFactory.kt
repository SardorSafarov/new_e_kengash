package com.example.e_kengash.network.viewModelFactory.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.login.LoginViewModel


class LoginViewModelFactory(private val loginRepository: LoginRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRepository) as T
    }
}