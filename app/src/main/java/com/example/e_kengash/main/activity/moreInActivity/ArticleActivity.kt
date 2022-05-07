package com.example.e_kengash.main.activity.moreInActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}