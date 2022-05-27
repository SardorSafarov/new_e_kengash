package com.example.e_kengash.main.activity.moreInActivity.senatorAndDeputat.main

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivitySenatorAndDeputatBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.statusbarcolor

class SenatorAndDeputat : AppCompatActivity() {
    private lateinit var binding:ActivitySenatorAndDeputatBinding
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySenatorAndDeputatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
        statusbarcolor(Color.WHITE)
        navigationFragment()
        back()
        notification()
    }

    private fun navigationFragment() {
        binding.apply {
            btnSenator.setOnClickListener {
                bgBtn(btnSenator,btnDeputat)
                findNavController(R.id.senator_nav_fragment).navigate(R.id.senator_frag)
            }
            btnDeputat.setOnClickListener {
                bgBtn(btnDeputat,btnSenator)
                findNavController(R.id.senator_nav_fragment).navigate(R.id.deputat_frag)
            }
        }
    }

    private fun bgBtn(
        btn1: AppCompatTextView,
        btn2: AppCompatTextView,
    ) {
        btn1.apply {
            setBackgroundResource(R.drawable.bg_text_blue)
            setTextColor(resources.getColor(R.color.white))
        }
        btn2.apply {
            setBackgroundResource(R.color.white)
            setTextColor(resources.getColor(R.color.gray))
        }
    }

    private fun notification() {
        binding.notification.setOnClickListener {
            when ( sharePereferenseHelper.getAccessToken()) {
                "empty" -> {
                    signUp()
                }
                else -> {
                    startActivity(Intent(this, NotificationActivity::class.java))
                }
            }
        }
    }

    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(this, R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

//    override fun onBackPressed() {
//        when(findNavController(R.id.senator_nav_fragment).currentDestination?.id)
//        {
//            R.id.senator_frag->
//            {
//             finish()
//            }
//            R.id.deputat_frag->
//            {
//               bgBtn(binding.btnSenator,binding.btnDeputat)
//                super.onBackPressed()
//            }
//        }
//    }
}