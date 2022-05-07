package com.example.e_kengash.main.activity.moreInActivity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivitySecritariatBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class SecretariatActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecritariatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecritariatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
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