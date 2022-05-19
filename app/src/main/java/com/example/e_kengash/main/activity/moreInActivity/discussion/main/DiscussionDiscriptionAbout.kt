package com.example.e_kengash.main.activity.moreInActivity.discussion.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.e_kengash.databinding.ActivityDiscussionDiscriptionAboutBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class DiscussionDiscriptionAbout : AppCompatActivity() {
    private lateinit var binding: ActivityDiscussionDiscriptionAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiscussionDiscriptionAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        binding.apply {
            intent.apply {
                user.text = getStringExtra("user")
                modifiedDate.text = getStringExtra("modified_date")
                Glide.with(applicationContext).load(getStringExtra("user_image")).into(userImage)
                direction.text = getStringExtra("direction")
                status.text = getStringExtra("status")
                title.text = getStringExtra("title")
                content.text = getStringExtra("content")
                views.text = getStringExtra("views")
                like.text =getStringExtra("like")
                dislike.text = getStringExtra("dislike")
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