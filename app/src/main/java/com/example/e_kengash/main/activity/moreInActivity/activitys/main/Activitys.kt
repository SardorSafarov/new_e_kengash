package com.example.e_kengash.main.activity.moreInActivity.activitys.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityActivitysBinding

class Activitys : AppCompatActivity() {
    private lateinit var binding:ActivityActivitysBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitysBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}