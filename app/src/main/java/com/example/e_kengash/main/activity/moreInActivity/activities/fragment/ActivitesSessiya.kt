package com.example.e_kengash.main.activity.moreInActivity.activities.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.more.activities.ActivitiesAdapter
import com.example.e_kengash.databinding.FragmentActivitesSessiyaBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.activites.New
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong

class ActivitesSessiya : MoreBaseFragment<FragmentActivitesSessiyaBinding>(FragmentActivitesSessiyaBinding::inflate),ActivitiesAdapter.onClickListener {
    private val adapter: ActivitiesAdapter by lazy { ActivitiesAdapter(this,requireContext(),sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
        moreViewModel.activitesAllList {
            when(it.isSuccessful)
            {
                true->{
                    onResponse(it.body()!!.news)
                }
                else->{
                    tosatLong(requireContext(),"Serverda xatolik!!")
                    D("ActivitiesAll activitesAllList ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun onResponse(news: List<New>) {
        binding.apply {
            progressBar.invisible()
            recList.layoutManager = LinearLayoutManager(requireContext())
            recList.adapter = adapter
        }
        adapter.setData(news)
    }

    override fun itemSetOnClickLister(text: String) {

    }


}