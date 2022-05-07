package com.example.e_kengash.main.activity.login.fragment.signUp


import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentSignUpBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment

class SignUp : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun onViewCreate() {
        binding.phone.setText(requireArguments().getString("phone").toString())
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