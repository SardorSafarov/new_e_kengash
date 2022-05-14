package com.example.e_kengash.main.activity.moreInActivity.discussion.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityDiscussionDiscriptionAboutBinding

class DiscussionDiscriptionAbout : AppCompatActivity() {
    private lateinit var binding:ActivityDiscussionDiscriptionAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiscussionDiscriptionAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}