package com.example.e_kengash.main.activity.moreInActivity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.e_kengash.databinding.ActivityAboutSenatorBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class AboutSenatorActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAboutSenatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutSenatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        binding.apply {
            fullName.text = intent.getStringExtra("full_name")
            position.text = intent.getStringExtra("position")
            specialization.text = intent.getStringExtra("specialization")
            education.text = intent.getStringExtra("education")
            nationName.text = intent.getStringExtra("nation")
            status.text =intent.getStringExtra("status")
            Glide.with(this@AboutSenatorActivity).load(intent.getStringExtra("image")).into(image)
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