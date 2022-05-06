package com.example.e_kengash.main.fragments.newUser.login.fragment.sms


import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.databinding.FragmentCheckSmsBinding
import com.example.e_kengash.main.activity.MainActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.entity.login.sms.sendSms.SendSmsRequest
import com.example.e_kengash.network.repository.LoginRepository
import com.example.e_kengash.network.viewModel.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.tosatShort


class CheckSms : BaseFragment<FragmentCheckSmsBinding>(FragmentCheckSmsBinding::inflate) {
    private lateinit var loginViewMode: LoginViewModel
    override fun onViewCreate() {
        setUi()
        binding.txtPhone.setText(" +998${sharePereferenseHelper.getAccessPhone()} ")
        sendPhoneNumber()
        checkSms()
        sendSmsTime()
    }

    private fun sendSmsTime() {
        binding.returnSendSms.setOnClickListener {
            sendSmsTime()
            binding.time.visibility = View.VISIBLE
            binding.returnSendSms.visibility = View.INVISIBLE
            sendPhoneNumber()
        }

        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.time.setText("00:" + String.format("%02d", millisUntilFinished / 1000))
            }

            override fun onFinish() {
                binding.time.visibility = View.INVISIBLE
                binding.returnSendSms.visibility = View.VISIBLE
            }
        }.start()
    }

    private fun checkSms() {
        binding.done.setOnClickListener {
            val user = RegisterUserRequest(
                phone = sharePereferenseHelper.getAccessPhone(),
                first_name = sharePereferenseHelper.getAccessFirstName(),
                last_name = sharePereferenseHelper.getAccessLastName(),
                middle_name = sharePereferenseHelper.getAccessMidelName(),
                password = sharePereferenseHelper.getAccessPassword1(),
                password1 = sharePereferenseHelper.getAccessPassword2(),
                location = "ss",
                code = binding.txtSms.text.toString()
            )
            D(user.toString())
            loginViewMode.registerUser(user)
            { response ->
                if (response.isSuccessful)
                    onResponse(response.body())
                else
                    D("CheckSms registerUser false")
            }

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

    private fun sendPhoneNumber() {
        loginViewMode.sendPhone(sharePereferenseHelper.getAccessPhone()) {
            if (it.isSuccessful) {
                if (it.body()!!.error != 201) {
                    tosatShort(requireContext(), it.body()!!.message)
                }
            }
        }
    }

    private fun onResponse(body: RegisterUserResponse?) {
        sharePereferenseHelper.setAccessToken(body!!.token)
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finishAffinity()
    }

}