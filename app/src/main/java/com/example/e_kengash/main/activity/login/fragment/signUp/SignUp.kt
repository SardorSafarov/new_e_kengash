package com.example.e_kengash.main.activity.login.fragment.signUp


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentSignUpBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.login.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.login.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.tosatShort

class SignUp : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    private lateinit var loginViewMode: LoginViewModel
    override fun onViewCreate() {
        setUi()
        binding.phone.setText(requireArguments().getString("phone").toString())
        binding.apply {
            done.setOnClickListener{
//                sharePereferenseHelper.setAccessFirsName(firsName.text.toString())
//                sharePereferenseHelper.setAccessLastName(lastName.text.toString())
//                sharePereferenseHelper.setAccessMidelName(middleName.text.toString())
//                sharePereferenseHelper.setAccessPassword1(password1.text.toString())
//                sharePereferenseHelper.setAccessPassword2(password2.text.toString())
                if(password1.text.toString().trim() == password2.text.toString().trim() && password1.text.toString().length>=6)
                {
                    loginViewMode.registerUser(RegisterUserRequest(
                        phone = sharePereferenseHelper.getAccessPhone(),
                        last_name = lastName.text.toString(),
                        first_name = firsName.text.toString(),
                        middle_name = middleName.text.toString(),
                        password1 = password1.text.toString(),
                        password = password1.text.toString(),
                        location = "aa",
                    )){
                        if(it.isSuccessful)
                        {
                           findNavController().navigate(R.id.action_signUp_to_checkSms, Bundle().apply {
                               putString("key",it.body()!!.key_id)
                               putString("phone",binding.phone.text.toString())
                           })
                        }
                        else
                        {
                            D("SignUp registerUser false ${it.errorBody()}")
                        }
                    }
                }else
                {
                    tosatShort(requireContext(),"Parol xato!!")
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
}