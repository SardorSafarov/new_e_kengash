package com.example.e_kengash.main.fragments.appealsSend

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.R
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.FragmentAppealsSendBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.network.repository.appealsSend.AppealsSendRepository
import com.example.e_kengash.network.viewModel.appealsSend.AppealsSendViewModel
import com.example.e_kengash.network.viewModelFactory.appealsSend.AppealsSendViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible

class AppealsSend :BaseFragment<FragmentAppealsSendBinding>(FragmentAppealsSendBinding::inflate) {
    private lateinit var appealsSendViewModel:AppealsSendViewModel

    override fun onViewCreate() {
//        checkToken()
        setUi()
        getAppealsType()
    }

    private fun checkToken() {
        when(sharePereferenseHelper.getAccessToken()){
            "empty"->{
                signUp()
            }
            else->{

            }
        }
    }

    private fun getAppealsType() {
        appealsSendViewModel.appealsType {
            when(it.isSuccessful)
            {
                true->{
                    binding.progressBar.invisible()
                    D("${it.body()}")
                }
                else->{
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
        val alertDialog:AlertDialog.Builder = AlertDialog.Builder(requireContext(),R.style.Style_Dialog_Rounded_Corner)
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