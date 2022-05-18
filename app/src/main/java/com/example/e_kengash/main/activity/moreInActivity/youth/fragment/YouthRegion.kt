package com.example.e_kengash.main.activity.moreInActivity.youth.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.youth.YouthDeputatAdapter
import com.example.e_kengash.databinding.FragmentYouthRegionBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.council.deputat.Deputy
import com.example.e_kengash.network.entity.more.youth.deputat.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible

class YouthRegion :
    MoreBaseFragment<FragmentYouthRegionBinding>(FragmentYouthRegionBinding::inflate),
    YouthDeputatAdapter.onClickListener{


    private val adapter:YouthDeputatAdapter by lazy { YouthDeputatAdapter(this,context,sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
        youthViewModel.getDeputatList {
            when(it.isSuccessful){
                true->{
                    onResponse(it.body()!!.info)
                }
                else->{
                    D("YouthRegion getDeputatList ${it.errorBody()!!.string()}")
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
        binding.apply {
            progressBar.invisible()
            recRegionList.adapter = adapter
            recRegionList.layoutManager =LinearLayoutManager(requireContext())
        }
        adapter.setData(info)
    }

    override fun setOnClickLister(id: Info) {

    }
}