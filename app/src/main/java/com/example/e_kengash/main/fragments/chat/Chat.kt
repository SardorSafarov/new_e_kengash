package com.example.e_kengash.main.fragments.chat

import android.content.Intent
import com.example.e_kengash.databinding.FragmentChatBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.viewModel.chat.ChatViewModel

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
//        chatViewModel.sendMessage(sharePereferenseHelper.getAccessToken(),)
    }
}