package com.example.e_kengash.main.activity.moreInActivity.activities.fragment

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.activities.ActivitiesAdapter
import com.example.e_kengash.databinding.FragmentActivitiesNewsBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.main.activity.moreInActivity.activities.main.ActivitiesAbout
import com.example.e_kengash.network.entity.more.activites.all.New
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong


class ActivitiesNews : MoreBaseFragment<FragmentActivitiesNewsBinding>(FragmentActivitiesNewsBinding::inflate),ActivitiesAdapter.onClickListener {
    private val adapter: ActivitiesAdapter by lazy { ActivitiesAdapter(this,requireContext(),sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
        moreViewModel.activitesNewsList {
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

    override fun itemSetOnClickLister(id: String) {
        moreViewModel.activitesAbout(id) {
            when (it.isSuccessful) {
                true -> {
                    activitesAbout(it.body()!!.news)
                }
                else -> {
                    tosatLong(requireContext(), "Serverda xatolik!!")
                    D("ActivitiesAll activitesAbout ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun activitesAbout(news: List<com.example.e_kengash.network.entity.more.activites.about.New>) {
        val intent = Intent(requireContext(), ActivitiesAbout::class.java)
        intent.apply {
            news[0].apply {
                putExtra("content", content)
                putExtra("image", image)
                putExtra("title", title)
                putExtra("date", date)
            }
        }
        startActivity(intent)
    }


}