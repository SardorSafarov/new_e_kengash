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
import com.example.e_kengash.network.repository.more.senator.SenatorRepository
import com.example.e_kengash.network.repository.more.youth.YouthRepository
import com.example.e_kengash.network.viewModel.more.council.CouncilViewModel
import com.example.e_kengash.network.viewModel.more.senator.SenatorViewModel
import com.example.e_kengash.network.viewModel.more.youth.YouthViewModel
import com.example.e_kengash.network.viewModelFactory.more.council.CouncilViewModelFactory
import com.example.e_kengash.network.viewModelFactory.more.senator.SenatorVewModelFactory
import com.example.e_kengash.network.viewModelFactory.more.youth.YouthViewModelFactory


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class MoreBaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    lateinit var councilViewModel: CouncilViewModel
    lateinit var youthViewModel: YouthViewModel
    lateinit var senatorViewModel: SenatorViewModel


    lateinit var sharePereferenseHelper: SharePereferenseHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharePereferenseHelper = SharePereferenseHelper(requireContext())
        _binding = inflate.invoke(inflater, container, false)
        councilSetUi()
        youthSetUi()
        senatorSetUi()
        return binding.root
    }

    private fun senatorSetUi() {
        val senatorRepository = SenatorRepository()
        val senatorVewModelFactory = SenatorVewModelFactory(senatorRepository)
        val senatorViewModel = ViewModelProvider(
            this,
            senatorVewModelFactory
        ).get(SenatorViewModel::class.java)
        this.senatorViewModel = senatorViewModel
    }

    private fun youthSetUi() {
        val youthRepository = YouthRepository()
        val youthViewModelFactory = YouthViewModelFactory(youthRepository)
        val youthViewModel = ViewModelProvider(
            this,
            youthViewModelFactory
        ).get(YouthViewModel::class.java)
        this.youthViewModel = youthViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate()
    }

    private fun councilSetUi() {
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
