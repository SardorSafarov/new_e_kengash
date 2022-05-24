package com.example.e_kengash.main.activity.moreInActivity.document.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityDocumentSearchBinding
import com.example.e_kengash.repetitive.statusbarcolor

class DocumentSearchActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDocumentSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
    }
}