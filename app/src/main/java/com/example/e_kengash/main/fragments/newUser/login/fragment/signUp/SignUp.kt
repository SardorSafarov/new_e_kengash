package com.example.e_kengash.main.fragments.newUser.login.fragment.signUp


import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentSignUpBinding
import com.example.e_kengash.main.activity.MainActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.repository.LoginRepository
import com.example.e_kengash.network.viewModel.LoginViewModel
import com.example.e_kengash.network.viewModelFactory.LoginViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.tosatShort

class SignUp : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    private lateinit var loginViewMode: LoginViewModel
    override fun onViewCreate() {
        setUi()
        binding.phone.setText(sharePereferenseHelper.getAccessPhone())
        binding.apply {
            done.setOnClickListener{

                loginViewMode.sendPhone(phone.text.toString()){
                    if(it.isSuccessful)
                    {
                        if (it.body()!!.error==201)
                        {
                            navController.navigate(R.id.checkSms)
                        }
                        else{
                            tosatShort(requireContext(),it.body()!!.message)
                        }

                    }
                }
//                loginViewMode.registerUser(
//                    RegisterUserRequest(
//                        phone=phone.text.toString(),
//                        first_name = firsName.text.toString(),
//                        last_name = lastName.text.toString(),
//                        middle_name = middleName.text.toString(),
//                        password = password1.text.toString(),
//                        password1 = password2.text.toString(),
//                        location = "ss"
//                    )
//                )
//                {response->
//                    if(response.isSuccessful)
//                    onResponse(response.body())
//                    else
//                        D("SignUp registerUser false")
//                }
            }
        }
    }

    private fun onResponse(body: RegisterUserResponse?) {
        sharePereferenseHelper.setAccessToken(body!!.token)
        startActivity(Intent(requireContext(),MainActivity::class.java))
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