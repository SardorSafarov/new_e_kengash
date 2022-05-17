package com.example.e_kengash.main.activity.moreInActivity.council.fragment.councilDeputat


import com.example.e_kengash.databinding.FragmentCouncilDeputatDataBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.network.entity.more.council.changeDeputat.info.Info
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible


class CouncilDeputatData : MoreBaseFragment<FragmentCouncilDeputatDataBinding>(FragmentCouncilDeputatDataBinding::inflate) {

    override fun onViewCreate() {

        councilViewModel.changeDeputatInfo(sharePereferenseHelper.getAccessDeputatId()){
            if(it.isSuccessful)
            {
              onResponse(it.body()!!.info[0])
            }else
                D(it.errorBody()!!.string())
        }
    }

    private fun onResponse(info: Info) {
        binding.apply {
            progressBar.invisible()
            position.text =info.position
            birthday.text = info.birthday
            education.text =info.education
            birthdayRegion.text =info.birth_region
            specialization.text = info.specialization
        }
    }

}