package com.example.e_kengash.main.fragments.more.main

import android.content.Intent
import com.example.e_kengash.databinding.FragmentMoreBinding
import com.example.e_kengash.main.activity.moreInActivity.ArticleActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.main.activity.moreInActivity.SecretariatActivity

class More : BaseFragment<FragmentMoreBinding>(FragmentMoreBinding::inflate) {
    override fun onViewCreate() {
        binding.apply {
            secretariat.setOnClickListener {
                startActivity(Intent(requireContext(), SecretariatActivity::class.java))
            }
            articles.setOnClickListener {
                startActivity(Intent(requireContext(),ArticleActivity::class.java))
            }
        }
    }

}