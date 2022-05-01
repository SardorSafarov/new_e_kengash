package com.example.e_kengash.network.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.login.CheckUserRequest
import com.example.e_kengash.network.entity.login.CheckUserResponse
import com.example.e_kengash.network.repository.LoginRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val loginRepository: LoginRepository):ViewModel() {


    fun checkUser(tel:CheckUserRequest,onResponse: (response: Response<CheckUserResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(loginRepository.checkUser(tel))
            }catch (e:Exception)
            {
                D("LoginViewModel checkUser  ${e.message}")
            }
        }
    }
}