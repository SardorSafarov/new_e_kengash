package com.example.e_kengash.main.activity.moreInActivity.acceptance.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ActivityAcceptanceBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class AcceptanceActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAcceptanceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcceptanceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        navigationFragment()
    }
    private fun navigationFragment() {
        binding.apply {
            btnAcceptance.setOnClickListener {
                bgBtn(btnAcceptance, btnSignUp)
                findNavController(R.id.acceptance_nav_fragment).navigate(R.id.acceptanceWrite)
            }
            btnSignUp.setOnClickListener {
                bgBtn(btnSignUp, btnAcceptance)
                findNavController(R.id.acceptance_nav_fragment).navigate(R.id.acceptanceSignUp)
            }
        }
    }

    private fun bgBtn(
        btn1: AppCompatTextView,
        btn2: AppCompatTextView,
        ) {
        btn1.apply {
            setBackgroundResource(R.drawable.bg_text_blue)
            setTextColor(resources.getColor(R.color.white))
        }
        btn2.apply {
            setBackgroundResource(R.color.white)
            setTextColor(resources.getColor(R.color.gray))
        }
    }

    private fun notification() {
        binding.notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

//    override fun onBackPressed() {
//
//        when(findNavController(R.id.acceptance_nav_fragment).currentDestination?.id)
//        {
//            R.id.acceptanceWrite->
//            {
//                finish()
//            }
//            R.id.acceptanceSignUp->
//            {
//                bgBtn(binding.btnAcceptance,binding.btnSignUp)
//                super.onBackPressed()
//            }
//        }
//
//    }
}