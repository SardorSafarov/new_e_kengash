package com.example.e_kengash.main.fragments.appeals

import android.app.AlertDialog
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appeal.AppealsTopMenuAdapter
import com.example.e_kengash.databinding.FragmentAppealsBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.repetitive.tosatShort


class Appeals : BaseFragment<FragmentAppealsBinding>(FragmentAppealsBinding::inflate),AppealsTopMenuAdapter.onClickListener {
    lateinit var alertDialog: AlertDialog.Builder
    private val menuAdapter: AppealsTopMenuAdapter by lazy { AppealsTopMenuAdapter(this) }
    lateinit var menuItem: MutableList<String>

    override fun onViewCreate() {
        //checkToken()
        topMenuSetData()

    }

    private fun topMenuSetData() {
        binding.recMenu.apply {
            adapter = menuAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
          menuAdapter.setData(menuItem)
    }

//    private fun checkToken() {
//        if(sharePereferenseHelper.getAccessDeputatId() =="empty")
//        {
//            signUp()
//        }
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        alertDialog = AlertDialog.Builder(requireContext(), R.style.Style_Dialog_Rounded_Corner)
        menuItem =  mutableListOf(getString(R.string.barchasi), getString(R.string.korib_chiqilmoqda), getString(R.string.yakunlangan), getString(R.string.korilmagan))
    }

//    private fun signUp() {
//        val view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_sign_up,null)
//        val dialogBind = AlertDialogSignUpBinding.bind(view)
//        dialogBind.done.setOnClickListener{
//            startActivity(Intent(requireContext(), LoginActivity::class.java))
//        }
//        alertDialog.apply {
//            setView(view)
//            show()
//        }
//    }

    override fun setOnClickLister(text: String) {
        tosatShort(requireContext(), text)
    }

}