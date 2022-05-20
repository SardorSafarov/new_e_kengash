package com.example.e_kengash.main.activity.moreInActivity.activities.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ActivityActivitysBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class ActivitiesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityActivitysBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitysBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        navigationFragment()
    }
    private fun navigationFragment() {
        binding.apply {
            btnAll.setOnClickListener {
                bgBtn(btnAll, btnNew,btnSesiya)
                findNavController(R.id.activities_nav_fragment).navigate(R.id.activitiesAll)
            }
            btnNew.setOnClickListener {
                bgBtn(btnNew, btnAll,btnSesiya)
                findNavController(R.id.activities_nav_fragment).navigate(R.id.activitiesNews)
            }
            btnSesiya.setOnClickListener {
                bgBtn(btnSesiya,btnNew, btnAll)
                findNavController(R.id.activities_nav_fragment).navigate(R.id.activitesSessiya)
            }
        }
    }

    private fun bgBtn(
        btn1: AppCompatTextView,
        btn2: AppCompatTextView,
        btn3: AppCompatTextView,

        ) {
        btn1.apply {
            setBackgroundResource(R.drawable.bg_text_blue)
            setTextColor(resources.getColor(R.color.white))
        }
        btn2.apply {
            setBackgroundResource(R.color.white)
            setTextColor(resources.getColor(R.color.gray))
        }
        btn3.apply {
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
}