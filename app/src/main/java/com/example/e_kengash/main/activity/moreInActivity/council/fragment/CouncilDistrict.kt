package com.example.e_kengash.main.activity.moreInActivity.council.fragment


import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appealsSend.bottomSheet.MFYAdapter
import com.example.e_kengash.adapter.entity.AddressEntity
import com.example.e_kengash.databinding.BottomSheetDialogAppealsSendBinding
import com.example.e_kengash.databinding.FragmentCouncilDistrictBinding
import com.example.e_kengash.main.activity.moreInActivity.MoreBaseFragment
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatLong
import com.google.android.material.bottomsheet.BottomSheetDialog

class CouncilDistrict :
    MoreBaseFragment<FragmentCouncilDistrictBinding>(FragmentCouncilDistrictBinding::inflate),
    MFYAdapter.onClickListener {
    private val mfyAdapter: MFYAdapter by lazy { MFYAdapter(this) }
    private lateinit var bottomSheetDiaolg: BottomSheetDialog
    private val districtList = ArrayList<AddressEntity>()
    override fun onViewCreate() {
        loadDistict()

        binding.btnDictirct.setOnClickListener{
            try {
                when(districtList.isNotEmpty()){
                    true->{
                        getDistict(districtList)
                    }
                    else->{
                      tosatLong(requireContext(),"Signal past!!")
                    }
                }
            }catch (e:Exception){
                D(e.message.toString())
            }
        }

    }



    private fun getDistict(addresses: ArrayList<AddressEntity>) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = mfyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        mfyAdapter.setData(addresses)
    }
    private fun loadDistict() {
        councilViewModel.getDistrict {
            when (it.isSuccessful) {
                true -> {
                    binding.progressBar.invisible()
                    it.body()!!.dictricts.forEach {
                        districtList.add(AddressEntity(id = it.id, name = it.name))
                    }
                }
                else -> {
                    tosatLong(requireContext(), "Serverda xatolik!!")
                    D("CouncilDistrict getDistrict ".plus(it.errorBody()!!.string()))
                }
            }
        }
    }
    override fun setOnClickListerMFY(text: AddressEntity) {
       binding.btnDictirct.text = text.name
        bottomSheetDiaolg.dismiss()
    }
}