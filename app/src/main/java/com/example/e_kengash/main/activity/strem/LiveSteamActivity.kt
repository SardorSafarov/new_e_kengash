package com.example.e_kengash.main.activity.strem

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityLiveSteamBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class LiveSteamActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLiveSteamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityLiveSteamBinding.inflate(layoutInflater)
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