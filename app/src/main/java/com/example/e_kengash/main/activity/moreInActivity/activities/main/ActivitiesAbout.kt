package com.example.e_kengash.main.activity.moreInActivity.activities.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import com.example.e_kengash.databinding.ActivityActivitiesAboutBinding
import com.example.e_kengash.databinding.FragmentActivitesSessiyaBinding
import com.example.e_kengash.repetitive.statusbarcolor

class ActivitiesAbout : AppCompatActivity() {
    private lateinit var binding: ActivityActivitiesAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        binding.apply {
            intent.apply {
                modifiedDate.text = getStringExtra("date")
                content.text = Html.fromHtml(getStringExtra("content"))
                title.text = getStringExtra("title")
                Glide.with(applicationContext).load(getStringExtra("image")).into(image)
            }
        }
    }
    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }
}