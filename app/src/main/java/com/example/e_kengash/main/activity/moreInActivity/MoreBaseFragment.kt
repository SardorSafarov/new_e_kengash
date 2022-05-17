package com.example.e_kengash.main.activity.moreInActivity

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
import com.example.e_kengash.network.repository.more.council.CouncilRepository
import com.example.e_kengash.network.viewModel.more.council.CouncilViewModel
import com.example.e_kengash.network.viewModelFactory.more.council.CouncilViewModelFactory


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class MoreBaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    lateinit var councilViewModel: CouncilViewModel

    lateinit var sharePereferenseHelper: SharePereferenseHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharePereferenseHelper = SharePereferenseHelper(requireContext())
        _binding = inflate.invoke(inflater, container, false)
        setUi()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate()
    }

    private fun setUi() {
        val councilRepository = CouncilRepository()
        val councilViewModelFactory = CouncilViewModelFactory(councilRepository)
        val councilViewModel = ViewModelProvider(
            this,
            councilViewModelFactory
        ).get(CouncilViewModel::class.java)
        this.councilViewModel = councilViewModel

    }

    abstract fun onViewCreate()

    operator fun VB.invoke(body: VB.() -> Unit) = this.apply { body() }

}
