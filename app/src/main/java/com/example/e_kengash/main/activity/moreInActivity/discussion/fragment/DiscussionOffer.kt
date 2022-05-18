package com.example.e_kengash.main.activity.moreInActivity.discussion.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.discussion.DiscussinOffertAdapter
import com.example.e_kengash.databinding.FragmentDiscussionOfferBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.discussion.offer.Result
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong


class DiscussionOffer : MoreBaseFragment<FragmentDiscussionOfferBinding>(FragmentDiscussionOfferBinding::inflate),DiscussinOffertAdapter.likeDislikeSetOnClickListener {
    private val adapter:DiscussinOffertAdapter by lazy { DiscussinOffertAdapter(this) }
    override fun onViewCreate() {
        moreViewModel.discussionOfferList{
            when(it.isSuccessful)
            {
                true->{
                    onResponse(it.body()!!.results)
                }
                else->{
                    tosatLong(requireContext(),"Serverda xatolik!!!")
                    D("DiscussionOffer discussionOfferList ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun onResponse(results: List<Result>) {
        binding.apply {
            progressBar.invisible()
            recList.layoutManager =LinearLayoutManager(requireContext())
            recList.adapter = adapter
        }
        adapter.setData(results)
    }

    override fun onClickListener(boolean: Boolean) {
        D(boolean.toString())
    }

}