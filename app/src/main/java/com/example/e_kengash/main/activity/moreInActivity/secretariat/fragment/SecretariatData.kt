package com.example.e_kengash.main.activity.moreInActivity.secretariat.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.secretariat.SecretariatDataAdapter
import com.example.e_kengash.databinding.FragmentSecretariatInfoBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.secretariat.data.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatShort

class SecretariatData : MoreBaseFragment<FragmentSecretariatInfoBinding>(FragmentSecretariatInfoBinding::inflate) {
    private val adapter:SecretariatDataAdapter by lazy { SecretariatDataAdapter() }
    override fun onViewCreate() {
        moreViewModel.secretariatDataList {
            when(it.isSuccessful)
            {
                true->
                {
                    onResponse(it.body()!!.info)
                }
                else->
                {
                    tosatShort(requireContext(),"Serverda xatolik!!")
                    D("SecretariatData secretariatDataList ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
        binding.apply {
            progressBar.invisible()
            recList.adapter = adapter
            recList.layoutManager = LinearLayoutManager(requireContext())
        }
        adapter.setData(info)
    }

}