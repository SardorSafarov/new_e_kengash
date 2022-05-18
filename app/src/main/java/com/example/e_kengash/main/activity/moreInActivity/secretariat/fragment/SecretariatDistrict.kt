package com.example.e_kengash.main.activity.moreInActivity.secretariat.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.secretariat.SecretariatRegionAdapter
import com.example.e_kengash.databinding.FragmentSecretariatDistrictBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.secretariat.region.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible


class SecretariatDistrict :
    MoreBaseFragment<FragmentSecretariatDistrictBinding>(FragmentSecretariatDistrictBinding::inflate),SecretariatRegionAdapter.onClickListener {

    private val adapterSec: SecretariatRegionAdapter by lazy { SecretariatRegionAdapter(this,requireContext(),sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
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


    override fun setOnClickLister(text: String) {

    }
}