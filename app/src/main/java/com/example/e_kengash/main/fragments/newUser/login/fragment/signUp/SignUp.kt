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

    override fun onViewCreate() {
        binding.phone.setText(sharePereferenseHelper.getAccessPhone())
        binding.apply {
            done.setOnClickListener{
                sharePereferenseHelper.setAccessFirsName(firsName.text.toString())
                sharePereferenseHelper.setAccessLastName(lastName.text.toString())
                sharePereferenseHelper.setAccessMidelName(middleName.text.toString())
                sharePereferenseHelper.setAccessPassword1(password1.text.toString())
                sharePereferenseHelper.setAccessPassword2(password2.text.toString())
                navController.navigate(R.id.checkSms)
            }
        }
    }
}