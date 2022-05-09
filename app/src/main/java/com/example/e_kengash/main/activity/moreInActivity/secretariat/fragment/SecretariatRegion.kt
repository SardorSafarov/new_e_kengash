package com.example.e_kengash.main.activity.moreInActivity.secretariat.fragment

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.secretariat.SecretariatRegionAdapter
import com.example.e_kengash.databinding.FragmentSecretariatRegionBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.secretariat.region.Info
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone

class SecretariatRegion : MoreBaseFragment<FragmentSecretariatRegionBinding>(
    FragmentSecretariatRegionBinding::inflate),SecretariatRegionAdapter.onClickListener {
    private lateinit var moreViewModel: MoreViewModel
    private val adapterSec:SecretariatRegionAdapter by lazy { SecretariatRegionAdapter(this) }
    override fun onViewCreate() {
        setUi()
        getSecRegionList()
    }

    private fun getSecRegionList() {
        moreViewModel.secRegionList {
            when(it.isSuccessful)
            {
                true->{
                    onResponse(it.body()!!.info)
                }
                else->{
                    D("SecretariatRegion secRegionList ${it.errorBody()!!.string()}")
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
            binding.apply {
                progressBar.gone()
                recRegionList.apply {
                    adapter = adapterSec
                    layoutManager = LinearLayoutManager(requireContext())
                }
            }
        adapterSec.setData(info)
    }

    private fun setUi() {
        val articleRepository = MoreRepository()
        val articleViewModelFactory = MoreViewModelFactory(articleRepository)
        val articleViewModel = ViewModelProvider(
            this,
            articleViewModelFactory
        ).get(MoreViewModel::class.java)
        this.moreViewModel = articleViewModel

    }

    override fun setOnClickLister(text: String) {

    }
}