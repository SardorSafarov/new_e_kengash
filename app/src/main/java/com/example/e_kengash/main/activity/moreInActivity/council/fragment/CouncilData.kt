package com.example.e_kengash.main.activity.moreInActivity.council.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.QuastionAdapter
import com.example.e_kengash.databinding.FragmentCouncilDataBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible

class CouncilData :
    MoreBaseFragment<FragmentCouncilDataBinding>(FragmentCouncilDataBinding::inflate),
    QuastionAdapter.onClickListener {
    private val adapterQuastionAdapter: QuastionAdapter by lazy { QuastionAdapter(this) }
    override fun onViewCreate() {
        councilViewModel.getDataList {
            when(it.isSuccessful)
            {
                true->{
                    binding.apply {
                        progressBar.invisible()
                        recList.adapter = adapterQuastionAdapter
                        recList.layoutManager = LinearLayoutManager(requireContext())
                    }
                    adapterQuastionAdapter.setData(it.body()!!.info)
                }
                else->{
                    D("CouncilData getDataList ${it.errorBody()!!.string()}")
                }
            }
        }
    }

    override fun setOnClickLister(text: String) {

    }

}