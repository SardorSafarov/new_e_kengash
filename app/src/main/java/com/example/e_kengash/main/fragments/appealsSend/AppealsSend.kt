package com.example.e_kengash.main.fragments.appealsSend

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appealsSend.bottomSheet.*
import com.example.e_kengash.databinding.BottomSheetDialogAppealsSendBinding
import com.example.e_kengash.databinding.FragmentAppealsSendBinding
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
    AppealsTypeAdapter.onClickListener,DirectionAdapter.onClickListener,RegionAdapter.onClickListener,DistrictAdapter.onClickListener,MFYAdapter.onClickListener {
    private lateinit var appealsSendViewModel: AppealsSendViewModel
    private lateinit var bottomSheetDiaolg: BottomSheetDialog
    private val appealsTypeAdapter: AppealsTypeAdapter by lazy { AppealsTypeAdapter(this) }
    private val directionAdapter: DirectionAdapter by lazy { DirectionAdapter(this) }
    private val regionAdapter: RegionAdapter by lazy { RegionAdapter(this) }
    private val districtAdapter: DistrictAdapter by lazy { DistrictAdapter(this) }
    private val mfyAdapter: MFYAdapter by lazy { MFYAdapter(this) }
    private var application:Int = 0
    private var direction:Int = 0
    private var region:Int = 0
    private var district:Int = 0
    private var mfy:Int = 0
    private var pickImage:Int = 100
    private var imageUri: Uri? = null

    private lateinit var appealsList: MutableList<AppealType>
    private lateinit var directionList: MutableList<Direction>
    private lateinit var regionList: MutableList<Addresse>
    private  var districtList: DistrictResponse? = null
    private  var mfyList: DistrictResponse? = null

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
            mfy.setOnClickListener {
                try {
                    if(districtList!!.addresses.size!=0)
                        getMFY(mfyList!!)
                }catch (e:Exception){
                    tosatShort(requireContext(),"Signal past!!")
                }
            }
            file.setOnClickListener {
                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                startActivityForResult(gallery, pickImage)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.file.setImageURI(imageUri)
        }
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

    private fun getMFY(addresses: DistrictResponse) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = mfyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        mfyAdapter.setData(addresses.addresses)
    }

    override fun setOnClickListerAppeals(item: AppealType) {
        application = item.id
        binding.application.text = item.name
        bottomSheetDiaolg.dismiss()
    }

    override fun setOnClickListerDirection(item: Direction) {
        direction = item.id
        binding.direction.text = item.name
        bottomSheetDiaolg.dismiss()
    }
    override fun setOnClickListerRegion(item: Addresse) {
        region = item.id
        getRequestDistrictList(region.toString())
        binding.region.text = item.name
        bottomSheetDiaolg.dismiss()
    }

    override fun setOnClickListerDistrict(item: com.example.e_kengash.network.entity.appealsSend.district.Addresse) {
        district =item.id
        getRequestMfyList(district.toString())
        binding.district.text = item.name
        bottomSheetDiaolg.dismiss()
    }

    override fun setOnClickListerMFY(item: com.example.e_kengash.network.entity.appealsSend.district.Addresse) {
        mfy =item.id
        binding.mfy.text = item.name
        bottomSheetDiaolg.dismiss()
    }





    private fun getRequestMfyList(district: String) {
        appealsSendViewModel.getMFY(district){
            when(it.isSuccessful)
            {
                true ->{
                    mfyList =it.body()!!
                }
                else ->{
                    D("AppealsSend getRequestMfyList false ${it.errorBody()!!.string()}")
                }
            }
        }
    }



    private fun getRequestDistrictList(region: String) {
        appealsSendViewModel.getDistict(region){
            when(it.isSuccessful)
            {
                true ->{
                    districtList =it.body()!!}
                else ->{
                    D("AppealsSend   getRequestDistrictList false ${it.errorBody()!!.string()}")
                }
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
                        D("AppealsSend getRequestAppealsAndDirectionAndRegion false ${it.errorBody()?.string()}")
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