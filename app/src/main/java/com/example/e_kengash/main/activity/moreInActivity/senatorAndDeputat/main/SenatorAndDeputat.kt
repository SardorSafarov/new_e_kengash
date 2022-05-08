package com.example.e_kengash.main.activity.moreInActivity.senatorAndDeputat.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivitySenatorAndDeputatBinding

class SenatorAndDeputat : AppCompatActivity() {
    private lateinit var binding:ActivitySenatorAndDeputatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySenatorAndDeputatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}