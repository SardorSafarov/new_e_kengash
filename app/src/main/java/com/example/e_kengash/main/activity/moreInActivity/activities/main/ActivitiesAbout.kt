package com.example.e_kengash.main.activity.moreInActivity.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityActivitiesAboutBinding
import com.example.e_kengash.databinding.FragmentActivitesSessiyaBinding

class ActivitiesAbout : AppCompatActivity() {
    private lateinit var binding: ActivityActivitiesAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}