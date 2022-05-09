package com.example.e_kengash.main.activity.moreInActivity.youth.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ActivityYouthBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.statusbarcolor

class YouthActivity : AppCompatActivity() {
    private lateinit var binding:ActivityYouthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYouthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        navigationFragment()
    }

    private fun navigationFragment() {
        binding.apply {
            btnData.setOnClickListener {
                bgBtn(btnData, btnRegion)
                findNavController(R.id.youth_nav_fragment).navigate(R.id.youthData)
            }
            btnRegion.setOnClickListener {
                bgBtn(btnRegion, btnData)
                findNavController(R.id.youth_nav_fragment).navigate(R.id.youthRegion)
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

    override fun onBackPressed() {

        when(findNavController(R.id.youth_nav_fragment).currentDestination?.id)
        {
            R.id.youthData->
            {
                finish()
            }
            R.id.youthRegion->
            {
                bgBtn(binding.btnData,binding.btnRegion)
            }
        }
        super.onBackPressed()
    }
}