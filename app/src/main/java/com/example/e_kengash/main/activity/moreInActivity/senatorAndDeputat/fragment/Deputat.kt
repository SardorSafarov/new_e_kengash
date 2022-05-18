package com.example.e_kengash.main.activity.moreInActivity.senatorAndDeputat.fragment


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.senator.SenatorAdapter
import com.example.e_kengash.databinding.FragmentDeputatBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.senator.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatShort


class Deputat : MoreBaseFragment<FragmentDeputatBinding>(FragmentDeputatBinding::inflate){
    private val adapter:SenatorAdapter by lazy { SenatorAdapter(requireContext(),sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
        senatorViewModel.getDeputatList {
            when(it.isSuccessful)
            {
                true->{
                    onResponse(it.body()!!.info)
                }
                else->{
                    tosatShort(requireContext(),"Serverda xatolik!!")
                    D("Deputat  getDeputatList ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
        binding.apply {
            progressBar.invisible()
            recRegionList.layoutManager =LinearLayoutManager(requireContext())
            recRegionList.adapter =adapter
        }
        adapter.setData(info)
    }

}