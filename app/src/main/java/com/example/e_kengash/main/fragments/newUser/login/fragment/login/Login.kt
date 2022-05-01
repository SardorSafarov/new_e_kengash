package com.example.e_kengash.main.fragments.newUser.login.fragment.login

import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentLoginBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.repository.LoginRepository
import com.example.e_kengash.network.viewModel.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import retrofit2.Response

class Login : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){
    private lateinit var loginViewMode: LoginViewModel

    override fun onViewCreate() {
        setUi()
        binding.done.setOnClickListener{

            loginViewMode.checkUser(CheckUserRequest(phone = binding.phone.text.toString()))
            {   response ->
                if(response.isSuccessful)
                onResponse(response)
                else
                {
                    D("Login checkUser false  ${response.errorBody().toString()}")
                }

            }
        }
    }

    private fun onResponse(response: Response<CheckUserResponse>) {
        if(response.body()!!.user == true)
        {
            navController.navigate(R.id.signIn)
            sharePereferenseHelper.setAccessPhone(binding.phone.text.toString())
        }else
        {
            navController.navigate(R.id.signUp)
            sharePereferenseHelper.setAccessPhone(binding.phone.text.toString())
        }
    }


    private fun setUi() {
        val loginRepository = LoginRepository()
        val loginViewModelFactory = LoginViewModelFactory(loginRepository)
        val takliflarLayfxaklarViewModel = ViewModelProvider(
            this,
            loginViewModelFactory
        ).get(LoginViewModel::class.java)
        this.loginViewMode = takliflarLayfxaklarViewModel

    }
}