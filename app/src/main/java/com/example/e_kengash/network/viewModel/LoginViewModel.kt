package com.example.e_kengash.network.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import com.example.e_kengash.network.entity.login.sms.sendSms.SendSmsResponse
import com.example.e_kengash.network.repository.LoginRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val loginRepository: LoginRepository):ViewModel() {


    fun checkUser(tel: CheckUserRequest, onResponse: (response: Response<CheckUserResponse>) -> Unit)
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

    fun registerUser(request:RegisterUserRequest, onResponse: (response: Response<RegisterUserResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(loginRepository.registerUser(request))
            }catch (e:Exception)
            {
                D("LoginViewModel registerUser  ${e.message}")
            }
        }
    }

    fun signIn(request:SignInRequest, onResponse: (response: Response<SignInResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(loginRepository.signIn(request))
            }catch (e:Exception)
            {
                D("LoginViewModel signIn  ${e.message}")
            }
        }
    }

    fun sendPhone(request:String, onResponse: (response: Response<SendSmsResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(loginRepository.sendPhone(request))
            }catch (e:Exception)
            {
                D("LoginViewModel sendPhone  ${e.message}")
            }
        }
    }
}