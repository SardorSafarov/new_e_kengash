package com.example.e_kengash.main.fragments.newUser.login.fragment.signIn

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentSignInBinding
import com.example.e_kengash.main.activity.MainActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.signIn.SignInRequest
import com.example.e_kengash.network.entity.login.signIn.SignInResponse
import com.example.e_kengash.network.repository.LoginRepository
import com.example.e_kengash.network.viewModel.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.tosatShort


class SignIn : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    private lateinit var loginViewMode: LoginViewModel
    override fun onViewCreate() {
        setUi()
        binding.apply {
            phone.setText(sharePereferenseHelper.getAccessPhone())
            done.setOnClickListener {
                loginViewMode.signIn(SignInRequest(
                    phone = phone.text.toString(),
                    password1 = password.text.toString(),
                    password = password.text.toString()
                ))
                {
                    if(it.isSuccessful)
                    onResponse(it.body())
                    else{
                        D("SignIn signIn false")
                        tosatShort(requireContext(),"Parol yoki Telefon raqam xato")
                    }

                }
            }
        }
    }

    private fun onResponse(body: SignInResponse?) {
        sharePereferenseHelper.setAccessToken(body!!.token)
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finishAffinity()
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