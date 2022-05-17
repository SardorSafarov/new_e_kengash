package com.example.e_kengash.main.activity.moreInActivity.council.fragment.councilDeputat

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.council.ChangeDeputatArticleAdapter
import com.example.e_kengash.databinding.FragmentCouncilDeputatArticleBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.council.changeDeputat.article.Meeting
import com.example.e_kengash.network.entity.more.council.deputat.Deputy
import com.example.e_kengash.repetitive.invisible

class CouncilDeputatArticle : MoreBaseFragment<FragmentCouncilDeputatArticleBinding>(FragmentCouncilDeputatArticleBinding::inflate),ChangeDeputatArticleAdapter.onClickListener  {
        private val adapter:ChangeDeputatArticleAdapter by lazy { ChangeDeputatArticleAdapter(this,requireContext()) }
    override fun onViewCreate() {
        councilViewModel.changeDeputatArticle(sharePereferenseHelper.getAccessDeputatId()){
            when(it.isSuccessful)
            {
                true->{
                    onResponse(it.body()!!.meetings)
                }
                else->{

                }
            }
        }
    }

    private fun onResponse(meetings: List<Meeting>) {
        binding.apply {
            progressBar.invisible()
            recList.adapter = adapter
            recList.layoutManager =LinearLayoutManager(requireContext())
        }
        adapter.setData(meetings)
    }

    override fun setOnClickLister(id: Deputy) {
    }

}