package com.example.e_kengash.main.activity.moreInActivity.discussion.fragment

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.discussion.DiscussinOffertAdapter
import com.example.e_kengash.databinding.FragmentDiscussionOfferBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.main.activity.moreInActivity.discussion.main.DiscussionDiscriptionAbout
import com.example.e_kengash.network.entity.more.discussion.offer.Result
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong


class DiscussionOffer : MoreBaseFragment<FragmentDiscussionOfferBinding>(FragmentDiscussionOfferBinding::inflate),DiscussinOffertAdapter.likeDislikeSetOnClickListener {
    private val adapter:DiscussinOffertAdapter by lazy { DiscussinOffertAdapter(this) }
    override fun onViewCreate() {
        moreViewModel.discussionOfferList()
        moreViewModel.discussionOfferList.observe(viewLifecycleOwner, Observer {
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
        })
    }

    private fun onResponse(results: List<Result>) {
        binding.apply {
            progressBar.invisible()
            recList.layoutManager =LinearLayoutManager(requireContext())
            recList.adapter = adapter
        }
        adapter.setData(results)
    }

    override fun likeDisLike(boolean: Boolean, id: String) {
      when(boolean)
      {
          true->{
              moreViewModel.discussionLike(sharePereferenseHelper.getAccessToken(),id){
                  when(it.isSuccessful){
                      true->{
                            D(it.body()!!.toString())
                      }
                      else->{
                          tosatLong(requireContext(),"Serverda xatolik!!")
                          D("DiscussionOffer discussionLike ".plus(it.errorBody()!!.string()))
                      }
                  }
              }
          }
          else->{
              moreViewModel.discussionDisLike(sharePereferenseHelper.getAccessToken(),id){
                  when(it.isSuccessful){
                      true->{
                          D(it.body()!!.toString())
                      }
                      else->{
                          tosatLong(requireContext(),"Serverda xatolik!!")
                          D("DiscussionOffer discussionLike ".plus(it.errorBody()!!.string()))
                      }
                  }
              }
          }
      }
    }

    override fun itemOnclickListener(id: String) {
        D(id)
            moreViewModel.discussionOfferAbout(id)
            {
                when(it.isSuccessful)
                {
                    true->{
                        it.body()!!.apply {
                            val intent = Intent(requireContext(),DiscussionDiscriptionAbout::class.java)
                            intent.apply {
                                putExtra("id",id)
                                putExtra("user",user)
                                putExtra("modified_date",modified_date)
                                putExtra("user_image",user_image)
                                putExtra("direction",direction)
                                putExtra("status",status)
                                putExtra("title",title)
                                putExtra("content",content)
                                putExtra("views",views.toString())
                                putExtra("like",like.toString())
                                putExtra("dislike",dislike.toString())
                            }
                            startActivity(intent)
                        }
                    }
                    else->{
                        tosatLong(requireContext(),"Serverda xatolik!!!")
                        D(it.errorBody()!!.string())
                    }
                }
            }
    }

}