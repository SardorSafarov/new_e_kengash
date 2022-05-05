package com.example.e_kengash.main.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityNotificationBinding
import com.example.e_kengash.repetitive.statusbarcolor

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }
}