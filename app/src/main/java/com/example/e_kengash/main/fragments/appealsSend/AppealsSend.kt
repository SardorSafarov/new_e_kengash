package com.example.e_kengash.main.fragments.appealsSend

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appealsSend.bottomSheet.AppealsTypeAdapter
import com.example.e_kengash.adapter.appealsSend.bottomSheet.DirectionAdapter
import com.example.e_kengash.adapter.appealsSend.bottomSheet.DistrictAdapter
import com.example.e_kengash.adapter.appealsSend.bottomSheet.RegionAdapter
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.BottomSheetDialogAppealsSendBinding
import com.example.e_kengash.databinding.FragmentAppealsSendBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.appealsSend.district.DistrictResponse
import com.example.e_kengash.network.entity.appealsSend.region.Addresse
import com.example.e_kengash.network.entity.appealsSend.type.AppealType
import com.example.e_kengash.network.entity.appealsSend.type.Direction
import com.example.e_kengash.network.repository.appealsSend.AppealsSendRepository
import com.example.e_kengash.network.viewModel.appealsSend.AppealsSendViewModel
import com.example.e_kengash.network.viewModelFactory.appealsSend.AppealsSendViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatShort
import com.google.android.material.bottomsheet.BottomSheetDialog


class AppealsSend : BaseFragment<FragmentAppealsSendBinding>(FragmentAppealsSendBinding::inflate),
    AppealsTypeAdapter.onClickListener,DirectionAdapter.onClickListener,RegionAdapter.onClickListener,DistrictAdapter.onClickListener {
    private lateinit var appealsSendViewModel: AppealsSendViewModel
    private lateinit var bottomSheetDiaolg: BottomSheetDialog
    private val appealsTypeAdapter: AppealsTypeAdapter by lazy { AppealsTypeAdapter(this) }
    private val directionAdapter: DirectionAdapter by lazy { DirectionAdapter(this) }
    private val regionAdapter: RegionAdapter by lazy { RegionAdapter(this) }
    private val districtAdapter: DistrictAdapter by lazy { DistrictAdapter(this) }
    private var application:Int = 0
    private var direction:Int = 0
    private var region:Int = 0
    private var district:Int = 0

    private lateinit var appealsList: MutableList<AppealType>
    private lateinit var directionList: MutableList<Direction>
    private lateinit var regionList: MutableList<Addresse>
    private  var districtList: DistrictResponse? = null
    override fun onViewCreate() {
        setUi()
        getRequestAppealsAndDirectionAndRegion()
        binding.apply {
            application.setOnClickListener {
                try {
                    getAppealsType(appealsList)
                }catch (e:Exception){
                    tosatShort(requireContext(),"Signal past!!")
                }

            }
            direction.setOnClickListener {
                try {
                    getDirection(directionList)
                }catch (e:Exception){
                    tosatShort(requireContext(),"Signal past!!")
                }
            }
            region.setOnClickListener {
                try {
                   getRegionn()
                }catch (e:Exception){
                    tosatShort(requireContext(),"Signal past!!")
                }
            }
            district.setOnClickListener {
                try {
                    if(districtList!!.addresses.size!=0)
                    getDistrict(districtList!!)
                }catch (e:Exception){
                    tosatShort(requireContext(),"Signal past!!")
                }
            }

        }
    }

    private fun getDistrict(addresses: DistrictResponse) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = districtAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        districtAdapter.setData(addresses.addresses)
    }
    override fun setOnClickListerDistrict(text: String) {
        binding.district.text = text
    }

    private fun getRegionn() {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = regionAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        regionAdapter.setData(regionList)
    }
    override fun setOnClickListerRegion(text: Addresse) {
        region = text.id
        getRequestDistrictList(region.toString())
        binding.region.text = text.name
        bottomSheetDiaolg.dismiss()
    }
    private fun getAppealsType(appealsList: MutableList<AppealType>) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = appealsTypeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        appealsTypeAdapter.setData(appealsList)
    }
    override fun setOnClickListerAppeals(text: String) {
        binding.application.text = text
        bottomSheetDiaolg.dismiss()
    }
    private fun getDirection(appealsList: MutableList<Direction>) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = directionAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        directionAdapter.setData(appealsList)
    }
    override fun setOnClickListerDirection(text: String) {
        binding.direction.text = text
        bottomSheetDiaolg.dismiss()
    }




    private fun getRequestDistrictList(region: String) {
        appealsSendViewModel.getDistict(region){
            when(it.isSuccessful)
            {
                true ->{
                    D(it.body().toString())
                    districtList =it.body()!!}
            }
        }
    }
    private fun getRequestAppealsAndDirectionAndRegion() {
        appealsSendViewModel.apply {
            appealsType {
                when (it.isSuccessful) {
                    true -> {
                        binding.progressBar.invisible()
                        appealsList = it.body()!!.appeal_types as MutableList<AppealType>
                        directionList = it.body()!!.directions as MutableList<Direction>
                    }
                    else -> {
                        D("AppealsSend getAppealsType ${it.errorBody()?.string()}")
                    }
                }
            }
            getRegion {
                when (it.isSuccessful) {
                    true -> {
                        regionList = it.body()!!.addresses as MutableList<Addresse>
                    }
                    else -> {
                        D("AppealsSend getAppealsType ${it.errorBody()?.string()}")
                    }
                }
            }
        }
    }


    private fun setUi() {
        val appealsSendRepository = AppealsSendRepository()
        val appealsSendViewModelFactory = AppealsSendViewModelFactory(appealsSendRepository)
        val appealsSendViewModel = ViewModelProvider(
            this,
            appealsSendViewModelFactory
        ).get(AppealsSendViewModel::class.java)
        this.appealsSendViewModel = appealsSendViewModel

    }






}