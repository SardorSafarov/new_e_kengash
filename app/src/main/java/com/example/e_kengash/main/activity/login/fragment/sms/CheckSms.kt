package com.example.e_kengash.main.activity.login.fragment.sms


import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.databinding.FragmentCheckSmsBinding
import com.example.e_kengash.main.activity.mainActivity.MainActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.sms.sendSms.CheckSmsRequest
import com.example.e_kengash.network.entity.login.sms.sendSms.CheckSmsResponse
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.login.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.login.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.tosatLong
import com.example.e_kengash.repetitive.tosatShort


class CheckSms : BaseFragment<FragmentCheckSmsBinding>(FragmentCheckSmsBinding::inflate) {
    private lateinit var loginViewMode: LoginViewModel
    override fun onViewCreate() {
        setUi()
        binding.txtPhone.setText(" ${requireArguments().getString("phone")} ")
        sendPhoneNumber()
        checkSms()
        smsTime()
    }

    private fun smsTime() {
        binding.returnSendSms.setOnClickListener {
            smsTime()
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

            loginViewMode.checkSms(CheckSmsRequest(
                phone = sharePereferenseHelper.getAccessPhone(),
                code = binding.txtSms.text.toString(),
                key_id = requireArguments().getString("key").toString()
            )){
                if(it.isSuccessful)
                {
                  onResponse(it.body())
                }else
                {
                    tosatLong(requireContext(),"Sms code xato kiritildi!!")
                 D("CheckSms checkSms false ${it.errorBody()!!.string()}")
                }
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

    private fun onResponse(body: CheckSmsResponse?) {
        sharePereferenseHelper.setAccessToken("Token ".plus(body!!.token))
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finishAffinity()
    }

}