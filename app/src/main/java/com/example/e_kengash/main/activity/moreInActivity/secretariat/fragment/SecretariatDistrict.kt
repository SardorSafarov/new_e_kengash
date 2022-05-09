package com.example.e_kengash.main.activity.moreInActivity.secretariat.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.secretariat.SecretariatRegionAdapter
import com.example.e_kengash.databinding.FragmentSecretariatDistrictBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.secretariat.region.Info
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.invisible


class SecretariatDistrict :
    MoreBaseFragment<FragmentSecretariatDistrictBinding>(FragmentSecretariatDistrictBinding::inflate),SecretariatRegionAdapter.onClickListener {
    private lateinit var moreViewModel: MoreViewModel
    private val adapterSec: SecretariatRegionAdapter by lazy { SecretariatRegionAdapter(this) }
    override fun onViewCreate() {
        setUi()
        getSecDistrictList()
    }
    private fun getSecDistrictList() {
        moreViewModel.secDistrictList {
            when(it.isSuccessful)
            {
                true->{
                    onResponse(it.body()!!.info)
                }
                else->{
                    D("SecretariatRegion secDistrictList ${it.errorBody()!!.string()}")
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
        binding.apply {
            progressBar.invisible()
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