package com.example.e_kengash.main.activity.moreInActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityAboutSenatorBinding

class AboutSenator : AppCompatActivity() {
    private lateinit var binding:ActivityAboutSenatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutSenatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}