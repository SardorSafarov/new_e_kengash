package com.example.e_kengash.main.fragments.baseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.network.repository.chat.ChatRepository
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.chat.ChatViewModel
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.chat.ChatViewModelFactory
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    lateinit var navController: NavController
    lateinit var sharePereferenseHelper:SharePereferenseHelper
    lateinit var chatViewModel: ChatViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharePereferenseHelper = SharePereferenseHelper(requireContext())
        _binding = inflate.invoke(inflater, container, false)
        chatSetUi()
        return binding.root
    }
    private fun chatSetUi() {
        val chatRepository = ChatRepository()
        val chaViewModelFactory = ChatViewModelFactory(chatRepository)
        val chatViewModel = ViewModelProvider(
            this,
            chaViewModelFactory
        ).get(ChatViewModel::class.java)
        this.chatViewModel = chatViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        onViewCreate()
    }
    abstract fun onViewCreate()
    operator fun VB.invoke(body: VB.() -> Unit) = this.apply { body() }
}
