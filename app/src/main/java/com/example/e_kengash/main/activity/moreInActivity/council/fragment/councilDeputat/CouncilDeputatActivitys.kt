package com.example.e_kengash.main.activity.moreInActivity.council.fragment.councilDeputat


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.council.changeDeputat.ChangeDeputatActivityAdapter
import com.example.e_kengash.databinding.FragmentCouncilDeputatActivitysBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.council.changeDeputat.activity.New
import com.example.e_kengash.network.entity.more.council.deputat.Deputy
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible


class CouncilDeputatActivitys :
    MoreBaseFragment<FragmentCouncilDeputatActivitysBinding>(FragmentCouncilDeputatActivitysBinding::inflate),
    ChangeDeputatActivityAdapter.onClickListener {

    private val adapter: ChangeDeputatActivityAdapter by lazy {
        ChangeDeputatActivityAdapter(
            this,
            requireContext()
        )
    }

    override fun onViewCreate() {
        councilViewModel.changeDeputatActivity(sharePereferenseHelper.getAccessDeputatId()) {
            when (it.isSuccessful) {
                true -> {
                    onResponse(it.body()!!.news)
                }
                else -> {
                    D(
                        "CouncilDeputatActivitys changeDeputatActivity false".plus(
                            it.errorBody()!!.string()
                        )
                    )
                }
            }
        }
    }

    private fun onResponse(news: List<New>) {
        binding.apply {
            progressBar.invisible()
            recList.adapter = adapter
            recList.layoutManager = LinearLayoutManager(requireContext())
        }
        adapter.setData(news)
    }

    override fun setOnClickLister(id: Deputy) {

    }

}