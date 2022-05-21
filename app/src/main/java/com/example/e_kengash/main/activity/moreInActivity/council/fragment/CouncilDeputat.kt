package com.example.e_kengash.main.activity.moreInActivity.council.fragment

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.council.CouncilDeputatAdapter
import com.example.e_kengash.databinding.FragmentCouncilDeputatBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.main.activity.moreInActivity.council.main.CouncilDeputatAbout
import com.example.e_kengash.network.entity.more.council.deputat.Deputy
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible


class CouncilDeputat : MoreBaseFragment<FragmentCouncilDeputatBinding>(FragmentCouncilDeputatBinding::inflate),CouncilDeputatAdapter.onClickListener {

    private val councilDeputatAdapter:CouncilDeputatAdapter by lazy { CouncilDeputatAdapter(this,requireContext(),sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
        getDeputatList()
    }

    private fun getDeputatList() {
        councilViewModel.councilDeputatList {
          when(it.isSuccessful)
          {
              true->{
                  binding.apply {
                      progressBar.invisible()
                      recRegionList.adapter = councilDeputatAdapter
                      recRegionList.layoutManager = LinearLayoutManager(requireContext())
                  }
                  councilDeputatAdapter.setData(it.body()!!.deputies)

              }
              else->{
                  D("CouncilDeputat getDeputatList ${it.errorBody()!!.string()}")
              }
          }
        }
    }



    override fun setOnClickLister(item: Deputy) {
          val intent = Intent(requireContext(),CouncilDeputatAbout::class.java)
        sharePereferenseHelper.setAccessDeputatId(item.id.toString())
        intent.putExtra("full_name",item.full_name)
        intent.putExtra("image",sharePereferenseHelper.getAccessDomen2().plus(item.image))
        startActivity(intent)
    }
}