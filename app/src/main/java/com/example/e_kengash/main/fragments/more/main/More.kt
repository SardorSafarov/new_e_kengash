package com.example.e_kengash.main.fragments.more.main

import android.content.Intent
import com.example.e_kengash.databinding.FragmentMoreBinding
import com.example.e_kengash.main.activity.moreInActivity.article.ArticleActivity
import com.example.e_kengash.main.activity.moreInActivity.commission.main.CommissionActivity
import com.example.e_kengash.main.activity.moreInActivity.discussion.main.DiscussionActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.main.activity.moreInActivity.secretariat.mian.SecretariatActivity
import com.example.e_kengash.main.activity.moreInActivity.senatorAndDeputat.main.SenatorAndDeputat
import com.example.e_kengash.main.activity.moreInActivity.youth.main.YouthActivity

class More : BaseFragment<FragmentMoreBinding>(FragmentMoreBinding::inflate) {
    override fun onViewCreate() {
        binding.apply {
            secretariat.setOnClickListener {
                startActivity(Intent(requireContext(), SecretariatActivity::class.java))
            }
            articles.setOnClickListener {
                startActivity(Intent(requireContext(), ArticleActivity::class.java))
            }
            senator.setOnClickListener {
                startActivity(Intent(requireContext(), SenatorAndDeputat::class.java))
            }
            youth.setOnClickListener {
                startActivity(Intent(requireContext(), YouthActivity::class.java))
            }
            discussion.setOnClickListener {
                startActivity(Intent(requireContext(), DiscussionActivity::class.java))
            }
            activitys.setOnClickListener {
                startActivity(Intent(requireContext(), DiscussionActivity::class.java))
            }
            commission.setOnClickListener {
                startActivity(Intent(requireContext(), CommissionActivity::class.java))
            }
        }
    }



}