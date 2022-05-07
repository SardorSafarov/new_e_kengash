package com.example.e_kengash.main.fragments.appeals

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appeal.AppealsTopMenuAdapter
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.FragmentAppealsBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.repetitive.tosatShort


class Appeals : BaseFragment<FragmentAppealsBinding>(FragmentAppealsBinding::inflate),AppealsTopMenuAdapter.onClickListener {
    lateinit var alertDialog: AlertDialog.Builder
    private val menuAdapter:AppealsTopMenuAdapter by lazy { AppealsTopMenuAdapter(this) }
    private val menuItem:MutableList<String> = mutableListOf("Barchasi","Ko'rib chiqilmoqda","Yakunlangan","Ko'rilmagan")
    override fun onViewCreate() {
        checkToken()
        topMenuSetData()

    }

    private fun topMenuSetData() {
        binding.recMenu.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        menuAdapter.setData(menuItem)
    }

    private fun checkToken() {
        if(sharePereferenseHelper.getAccessToken() =="empty")
        {
            signUp()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        alertDialog = AlertDialog.Builder(requireContext(), R.style.Style_Dialog_Rounded_Corner)
    }

    private fun signUp() {
        val view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_sign_up,null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener{
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }

    override fun setOnClickLister(text: String) {
      tosatShort(requireContext(),text)
    }

}