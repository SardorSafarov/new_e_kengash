package com.example.e_kengash.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import com.example.e_kengash.R
import com.example.e_kengash.databinding.BottomSheetDialogAppealsSendBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetDialogChoose(context: Context,list:ArrayList<String>) :BottomSheetDialog(context,
    R.style.BottomSheetDialogTheme) {
    private val binding = BottomSheetDialogAppealsSendBinding.inflate(layoutInflater,(layoutInflater.inflate(R.layout.bottom_sheet_dialog_appeals_send,null)as ViewGroup),false)

//    init {
//
//        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        setContentView(binding.root)
//        binding.apply {
//            recList.adapter = chooseAdapter
//            chooseAdapter.setOrderList(list)
//            chooseAdapter.setTypePositionListener {
//                buttonClickListener?.invoke(it)
//                dismiss()
//            }
//        }
//    }
}