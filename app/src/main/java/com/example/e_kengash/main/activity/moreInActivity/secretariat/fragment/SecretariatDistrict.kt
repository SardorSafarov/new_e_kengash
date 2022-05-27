package com.example.e_kengash.main.activity.moreInActivity.secretariat.fragment

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.secretariat.SecretariatRegionAdapter
import com.example.e_kengash.databinding.FragmentSecretariatDistrictBinding
import com.example.e_kengash.main.activity.moreInActivity.AboutSenatorActivity
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.secretariat.region.Info
import com.example.e_kengash.repetitive.*


class SecretariatDistrict :
    MoreBaseFragment<FragmentSecretariatDistrictBinding>(FragmentSecretariatDistrictBinding::inflate),
    SecretariatRegionAdapter.onClickListener {

    private val adapterSec: SecretariatRegionAdapter by lazy {
        SecretariatRegionAdapter(
            this,
            requireContext(),
            sharePereferenseHelper.getAccessDomen2()
        )
    }

    override fun onViewCreate() {
        getSecDistrictList()
    }

    private fun getSecDistrictList() {
        moreViewModel.secDistrictList {
            when (it.isSuccessful) {
                true -> {
                    onResponse(it.body()!!.info)
                }
                else -> {
                    binding.progressBar.invisible()
                    tosatShort(requireContext(), "Serverda xatolik!!")
                    D("SecretariatRegion secDistrictList ${it.errorBody()!!.string()}")
                }
            }
        }
    }

    private fun onResponse(info: List<Info>) {
        binding.apply {
            progressBar.invisible()
            recRegionList.apply {
                adapter = adapterSec
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
        adapterSec.setData(info)
    }


    override fun setOnClickLister(item: Info) {
        binding.progressBar.visible()
        moreViewModel.secretariatChangeDeputatData(item.id)
        {
            when (it.isSuccessful) {
                true -> {
                    binding.progressBar.invisible()
                  aboutSenator(it.body()!!.info[0])
                }
                else -> {
                    binding.progressBar.invisible()
                    tosatLong(requireContext(),"Serverda xatolik!!!")
                    D("SecretariatDistrict secretariatChangeDeputatData ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }

    private fun aboutSenator(info: com.example.e_kengash.network.entity.more.secretariat.changeDeputat.Info) {
        val intent = Intent(requireContext(), AboutSenatorActivity::class.java)
        intent.putExtra("full_name",info.full_name)
        intent.putExtra("position",info.position)
        intent.putExtra("image",sharePereferenseHelper.getAccessDomen2().plus(info.image))
        intent.putExtra("nation",info.nation)
        intent.putExtra("education",info.education)
        intent.putExtra("specialization",info.specialization)
        intent.putExtra("status",info.party)
        startActivity(intent)
    }
}