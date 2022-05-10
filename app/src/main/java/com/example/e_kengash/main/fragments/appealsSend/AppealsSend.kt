package com.example.e_kengash.main.fragments.appealsSend

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appealsSend.BottomSheetDiaolgAdapter
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.BottomSheetDialogAppealsSendBinding
import com.example.e_kengash.databinding.FragmentAppealsSendBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.network.entity.appealsSend.type.Result
import com.example.e_kengash.network.repository.appealsSend.AppealsSendRepository
import com.example.e_kengash.network.viewModel.appealsSend.AppealsSendViewModel
import com.example.e_kengash.network.viewModelFactory.appealsSend.AppealsSendViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.tosatShort
import com.google.android.material.bottomsheet.BottomSheetDialog


class AppealsSend : BaseFragment<FragmentAppealsSendBinding>(FragmentAppealsSendBinding::inflate),
    BottomSheetDiaolgAdapter.onClickListener {
    private lateinit var appealsSendViewModel: AppealsSendViewModel
    private lateinit var bottomSheetDiaolg: BottomSheetDialog
    private val bottomSheetAdapter: BottomSheetDiaolgAdapter by lazy { BottomSheetDiaolgAdapter(this) }
    override fun onViewCreate() {
        //      checkToken()
        setUi()
        binding.apply {
            application.setOnClickListener {
                getAppealsType()
            }
        }
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

    private fun getAppealsType() {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send, null)
        bottomSheetDiaolg = BottomSheetDialog(requireContext())
        val bottomSheetBind = BottomSheetDialogAppealsSendBinding.bind(view)
        bottomSheetDiaolg.apply {
            setContentView(view)
            show()
        }
        bottomSheetBind.recList.apply {
            adapter = bottomSheetAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        appealsSendViewModel.appealsType {
            when (it.isSuccessful) {
                true -> {
                    bottomSheetBind.progressBar.invisible()
                    bottomSheetAdapter.setData(it.body()!!.results)
                }
                else -> {
                    D("AppealsSend getAppealsType ${it.errorBody()?.string()}")
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

    override fun setOnClickLister(text: String) {
        binding.application.text = text
        bottomSheetDiaolg.dismiss()
    }
}