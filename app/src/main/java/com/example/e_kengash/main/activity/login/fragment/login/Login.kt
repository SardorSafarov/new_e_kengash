package com.example.e_kengash.main.activity.login.fragment.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentLoginBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.checkUser.CheckUserRequest
import com.example.e_kengash.network.entity.login.checkUser.CheckUserResponse
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.login.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.login.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import retrofit2.Response

class Login : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private lateinit var loginViewMode: LoginViewModel

    override fun onViewCreate() {
        setUi()
        binding.done.setOnClickListener {
            if (binding.phone.getRawText().length == 9) {
                loginViewMode.checkUser(CheckUserRequest(phone = binding.phone.getRawText()))
                { response ->
                    if (response.isSuccessful) {
                        onResponse(response)
                        sharePereferenseHelper.setAccessPhone(binding.phone.getRawText())
                    } else {
                        D("Login checkUser false  ${response.errorBody().toString()}")
                    }

                }
            } else binding.phone.error = getString(R.string.raqamni_kiriting)
        }
    }

    private fun onResponse(response: Response<CheckUserResponse>) {
        if (response.body()!!.user == true) {
            findNavController().navigate(R.id.action_login_to_signIn, Bundle().apply {
                putString("phone",binding.phone.text.toString())
            })

        } else {
            findNavController().navigate(R.id.action_login_to_signUp, Bundle().apply {
                putString("phone",binding.phone.text.toString())
            })
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