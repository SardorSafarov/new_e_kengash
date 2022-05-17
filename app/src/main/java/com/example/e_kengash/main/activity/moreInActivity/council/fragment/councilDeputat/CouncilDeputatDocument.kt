package com.example.e_kengash.main.activity.moreInActivity.council.fragment.councilDeputat

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.council.changeDeputat.ChangeDeputatDocAdapter
import com.example.e_kengash.databinding.FragmentCouncilDeputatDocumentBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.council.changeDeputat.doc.Document
import com.example.e_kengash.network.entity.more.council.deputat.Deputy
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible


class CouncilDeputatDocument : MoreBaseFragment<FragmentCouncilDeputatDocumentBinding>(FragmentCouncilDeputatDocumentBinding::inflate),ChangeDeputatDocAdapter.onClickListener {
    private val adapter:ChangeDeputatDocAdapter by lazy { ChangeDeputatDocAdapter(this,requireContext(),sharePereferenseHelper.getAccessDomen2()) }

    override fun onViewCreate() {
        D(sharePereferenseHelper.getAccessDeputatId())
        councilViewModel.changeDeputatDoc(sharePereferenseHelper.getAccessDeputatId()){
            when(it.isSuccessful){
                true->{
                    onResponse(it.body()!!.documents)
                }
                else->{
                    D("CouncilDeputatDocument changeDeputatDoc false ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun onResponse(documents: List<Document>) {
        binding.apply {
            progressBar.invisible()
            recList.adapter = adapter
            recList.layoutManager = LinearLayoutManager(requireContext())
        }
        adapter.setData(documents)
    }

    override fun setOnClickLister(id: Deputy) {

    }

}