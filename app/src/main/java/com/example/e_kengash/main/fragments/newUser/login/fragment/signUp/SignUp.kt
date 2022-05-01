package com.example.e_kengash.main.fragments.newUser.login.fragment.signUp


import com.example.e_kengash.databinding.FragmentSignUpBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.repetitive.D

class SignUp : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override fun onViewCreate() {
        binding.phone.setText(sharePereferenseHelper.getAccessPhone())
    }
}