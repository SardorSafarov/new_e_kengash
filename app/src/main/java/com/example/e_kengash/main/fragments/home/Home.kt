package com.example.e_kengash.main.fragments.home


import android.content.Intent
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentHomeBinding
import com.example.e_kengash.main.activity.LiveSteamActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment


class Home :  BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onViewCreate() {
        binding.chat.setOnClickListener {
            navController.navigate(R.id.chatFragment)
        }
        binding.neww.setOnClickListener {
            navController.navigate(R.id.newUserFragment)
        }
        binding.appleas.setOnClickListener {
            navController.navigate(R.id.appealsFragment)
        }
        binding.live.setOnClickListener {
            startActivity(Intent(requireContext(),LiveSteamActivity::class.java))
        }
    }
}