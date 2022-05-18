package com.example.e_kengash.main.activity.moreInActivity.youth.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.youth.YouthDataAdapter
import com.example.e_kengash.databinding.FragmentYouthDataBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.youth.data.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.visible

class YouthData :  MoreBaseFragment<FragmentYouthDataBinding>(FragmentYouthDataBinding::inflate) {

    private val adapter:YouthDataAdapter by lazy { YouthDataAdapter() }
        private var t=true
    override fun onViewCreate() {
        youthViewModel.getData {
            when(it.isSuccessful){
                true->{
                    D(it.body().toString())
                    binding.apply {
                        progressBar.invisible()
                        question.text=it.body()!!.info.title
                        answer.text=it.body()!!.info.content
                        item.setOnClickListener{
                            when(t)
                            {
                                true->{
                                    answer.visible()
                                    t=false
                                }
                                else->{
                                    answer.gone()
                                    t=true
                                }
                            }
                        }

                    }
                    //onResponse(it.body()!!.info)
                }
                else->{}
            }
        }
    }

//    private fun onResponse(info: Info) {
//            binding.apply {
//                progressBar.invisible()
//                recList.adapter = adapter
//                recList.layoutManager =LinearLayoutManager(requireContext())
//            }
//        adapter.setData(info)
//    }


}