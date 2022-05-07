package com.example.e_kengash.main.fragments.newUser

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import com.example.e_kengash.R
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.FragmentNewUserBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.main.activity.login.main.LoginActivity

class NewUser :BaseFragment<FragmentNewUserBinding>(FragmentNewUserBinding::inflate) {
   lateinit var alertDialog:AlertDialog.Builder
    override fun onViewCreate() {
        if(sharePereferenseHelper.getAccessToken() =="empty")
        {
            signUp()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        alertDialog = AlertDialog.Builder(requireContext(),R.style.Style_Dialog_Rounded_Corner)
    }

    private fun signUp() {
        val view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_sign_up,null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener{
            startActivity(Intent(requireContext(),LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }
}