package com.example.e_kengash.main.activity.myAppealsSendSuccess

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityMyAppealsSendSuccessBinding
import com.example.e_kengash.main.activity.mainActivity.MainActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class MyAppealsSendSuccess : AppCompatActivity() {
    private lateinit var binding:ActivityMyAppealsSendSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyAppealsSendSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        binding.apply {
            userId.text = intent.getStringExtra("_id")
            done.setOnClickListener {
                startActivity(Intent(this@MyAppealsSendSuccess,MainActivity::class.java))
                finishAffinity()
            }
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