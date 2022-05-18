package com.example.e_kengash.main.activity.moreInActivity.youth.fragment

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.youth.YouthDeputatAdapter
import com.example.e_kengash.databinding.FragmentYouthRegionBinding
import com.example.e_kengash.main.activity.moreInActivity.AboutSenatorActivity
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.youth.deputat.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong
import com.example.e_kengash.repetitive.visible

class YouthRegion :
    MoreBaseFragment<FragmentYouthRegionBinding>(FragmentYouthRegionBinding::inflate),
    YouthDeputatAdapter.onClickListener{


    private val adapter:YouthDeputatAdapter by lazy { YouthDeputatAdapter(this,context,sharePereferenseHelper.getAccessDomen2()) }
    override fun onViewCreate() {
        youthViewModel.getDeputatList {
            when(it.isSuccessful){
                true->{
                    onResponse(it.body()!!.info)
                }
                else->{
                    D("YouthRegion getDeputatList ${it.errorBody()!!.string()}")
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
        binding.apply {
            progressBar.invisible()
            recRegionList.adapter = adapter
            recRegionList.layoutManager =LinearLayoutManager(requireContext())
        }
        adapter.setData(info)
    }

    override fun setOnClickLister(item: Info) {
        binding.progressBar.visible()
            youthViewModel.changeDeputatData(item.id.toString()){
                when(it.isSuccessful){
                    true->{
                        binding.progressBar.invisible()
                        aboutSenator(it.body()!!.info[0])
                    }
                    else->{
                        binding.progressBar.invisible()
                        tosatLong(requireContext(),"Serverda xatolik!!!")
                        D("YouthRegion changeDeputatData ".plus(it.errorBody()!!.string()))
                    }
                }
            }
    }

    private fun aboutSenator(info: com.example.e_kengash.network.entity.more.youth.changeDeputat.Info) {
        val intent =Intent(requireContext(),AboutSenatorActivity::class.java)
        intent.putExtra("full_name",info.full_name)
        intent.putExtra("position",info.position)
        intent.putExtra("image",sharePereferenseHelper.getAccessDomen2().plus(info.image))
        intent.putExtra("nation",info.nation__name)
        intent.putExtra("education",info.education)
        intent.putExtra("specialization",info.specialization)
        intent.putExtra("status",info.status)
        startActivity(intent)
    }
}