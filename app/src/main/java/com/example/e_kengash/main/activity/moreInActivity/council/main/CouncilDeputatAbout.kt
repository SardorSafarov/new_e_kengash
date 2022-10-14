package com.example.e_kengash.main.activity.moreInActivity.council.main

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityCouncilDeputatAboutBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.login.webView.LoginWebActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class CouncilDeputatAbout : AppCompatActivity() {
    private lateinit var binding:ActivityCouncilDeputatAboutBinding
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCouncilDeputatAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        sharePereferenseHelper = SharePereferenseHelper(this)
        back()
        notification()
        navigationFragment()
        deputatData()
    }
    private fun deputatData() {
        binding.fullName.text = intent.getStringExtra("full_name")
    }
    override fun onResume() {
        super.onResume()
        Glide.with(baseContext)
            .load(intent.getStringExtra("image").toString())
            .into(binding.image)
    }

    private fun navigationFragment() {
        binding.apply {
            btnData.setOnClickListener {
                bgBtn(btnData, btnAppealsSend,btnAcceptanceWrite,btnArticle,btnActivitys,btnDocument)
                findNavController(R.id.council_deputat_nav_fragment).navigate(R.id.councilDeputatData)
            }
            btnAppealsSend.setOnClickListener {
                bgBtn(btnAppealsSend,btnData,btnAcceptanceWrite,btnArticle,btnActivitys,btnDocument)
                findNavController(R.id.council_deputat_nav_fragment).navigate(R.id.councilDeputatAppealsSend)
            }
            btnAcceptanceWrite.setOnClickListener {
                bgBtn(btnAcceptanceWrite, btnAppealsSend,btnData,btnArticle,btnActivitys,btnDocument)
                findNavController(R.id.council_deputat_nav_fragment).navigate(R.id.councilDeputatAcceptanceWrite)
            }
            btnArticle.setOnClickListener {
                bgBtn(btnArticle, btnAppealsSend,btnAcceptanceWrite,btnData,btnActivitys,btnDocument)
                findNavController(R.id.council_deputat_nav_fragment).navigate(R.id.councilDeputatArticle)
            }
            btnActivitys.setOnClickListener {
                bgBtn(btnActivitys, btnAppealsSend,btnAcceptanceWrite,btnArticle,btnData,btnDocument)
                findNavController(R.id.council_deputat_nav_fragment).navigate(R.id.councilDeputatActivitys)
            }
            btnDocument.setOnClickListener {
                bgBtn(btnDocument, btnAppealsSend,btnAcceptanceWrite,btnArticle,btnActivitys,btnData)
                findNavController(R.id.council_deputat_nav_fragment).navigate(R.id.councilDeputatDocument)
            }
        }
    }

    private fun bgBtn(
        btn1: TextView,
        btn2: TextView,
        btn3: TextView,
        btn4: TextView,
        btn5: TextView,
        btn6: TextView,

        ) {
        btn1.apply {
            setBackgroundResource(R.color.council_deputat)
            setTextColor(resources.getColor(R.color.black))
        }
        btn2.apply {
            setBackgroundResource(R.color.main_background)
            setTextColor(resources.getColor(R.color.gray))
        }
        btn3.apply {
            setBackgroundResource(R.color.main_background)
            setTextColor(resources.getColor(R.color.gray))
        }
        btn4.apply {
            setBackgroundResource(R.color.main_background)
            setTextColor(resources.getColor(R.color.gray))
        }
        btn5.apply {
            setBackgroundResource(R.color.main_background)
            setTextColor(resources.getColor(R.color.gray))
        }
        btn6.apply {
            setBackgroundResource(R.color.main_background)
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
            startActivity(Intent(this, LoginWebActivity::class.java))
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
}