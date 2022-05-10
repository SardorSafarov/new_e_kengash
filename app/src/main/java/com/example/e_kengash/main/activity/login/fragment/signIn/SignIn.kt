package com.example.e_kengash.main.activity.login.fragment.signIn

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentSignInBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.login.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.login.LoginViewModelFactory
import com.example.e_kengash.repetitive.D


class SignIn : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    private lateinit var loginViewMode: LoginViewModel
    override fun onViewCreate() {
        setUi()
        binding.apply {
            phone.setText(requireArguments().getString("phone").toString())
            done.setOnClickListener {
                loginViewMode.signIn(
                    SignInRequest(
                    phone = sharePereferenseHelper.getAccessPhone(),
                    password = password.text.toString()
                )
                )
                {
                    if(it.isSuccessful){
                        onResponse(it.body())
                    }
                    else{
                        D("SignIn signIn false")
                    }
                }
            }
        }
    }

    private fun onResponse(body: SignInResponse?) {
       findNavController().navigate(R.id.checkSms, Bundle().apply {
           putString("phone",binding.phone.text.toString())
           putString("key",body!!.key_id)
       })
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