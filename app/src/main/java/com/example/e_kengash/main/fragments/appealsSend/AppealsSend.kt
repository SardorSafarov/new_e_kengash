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
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.BottomSheetDialogAppealsSendBinding
import com.example.e_kengash.databinding.FragmentAppealsSendBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.appealsSend.type.AppealType
import com.example.e_kengash.network.entity.appealsSend.type.Direction
import com.example.e_kengash.network.repository.appealsSend.AppealsSendRepository
import com.example.e_kengash.network.viewModel.appealsSend.AppealsSendViewModel
import com.example.e_kengash.network.viewModelFactory.appealsSend.AppealsSendViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.google.android.material.bottomsheet.BottomSheetDialog


class AppealsSend : BaseFragment<FragmentAppealsSendBinding>(FragmentAppealsSendBinding::inflate),
    AppealsTypeAdapter.onClickListener,DirectionAdapter.onClickListener {
    private lateinit var appealsSendViewModel: AppealsSendViewModel
    private lateinit var bottomSheetDiaolg: BottomSheetDialog
    private val appealsTypeAdapter: AppealsTypeAdapter by lazy { AppealsTypeAdapter(this) }
    private val directionAdapter: DirectionAdapter by lazy { DirectionAdapter(this) }
    private lateinit var appealsList: MutableList<AppealType>
    private lateinit var directionList: MutableList<Direction>
    override fun onViewCreate() {
        setUi()
        getAppealsAndDirection()
        binding.apply {
            application.setOnClickListener {
                getAppealsType(appealsList)
            }
            direction.setOnClickListener {
                getDirection(directionList)
            }
        }
    }

    private fun getAppealsAndDirection() {
        appealsSendViewModel.appealsType {
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
    }
    private fun getAppealsType(appealsList: MutableList<AppealType>) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext())
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
        bottomSheetDiaolg = BottomSheetDialog(requireContext())
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


    private fun checkToken() {
        when (sharePereferenseHelper.getAccessToken()) {
            "empty" -> {
                signUp()
            }
            else -> {

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

    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(requireContext(), R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }




}