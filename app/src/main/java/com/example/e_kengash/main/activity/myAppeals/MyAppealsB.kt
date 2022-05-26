package com.example.e_kengash.main.activity.myAppeals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ActivityMyAppealsBBinding

class MyAppealsB : AppCompatActivity() {
    private lateinit var binding:ActivityMyAppealsBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyAppealsBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val xabar= intent.getStringExtra("message")
        binding.myAppealsB.text=xabar
    }
}