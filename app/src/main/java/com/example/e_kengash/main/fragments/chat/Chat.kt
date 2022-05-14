package com.example.e_kengash.main.fragments.chat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_kengash.R
import com.example.e_kengash.databinding.FragmentChatBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment

class Chat : BaseFragment<FragmentChatBinding>(FragmentChatBinding::inflate) {
    private val GALLERY_REQUEST = 2
    override fun onViewCreate() {
        binding.apply {
            sendFile.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent,GALLERY_REQUEST)
            }
        }
    }

}