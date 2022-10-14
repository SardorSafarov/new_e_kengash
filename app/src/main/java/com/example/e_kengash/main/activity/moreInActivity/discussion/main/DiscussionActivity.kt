package com.example.e_kengash.main.activity.moreInActivity.discussion.main

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityDiscussionBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.login.webView.LoginWebActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class DiscussionActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDiscussionBinding
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiscussionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        sharePereferenseHelper = SharePereferenseHelper(this)
        back()
        notification()
        navigationFragment()
    }

    private fun navigationFragment() {
        binding.apply {
            btnOffer.setOnClickListener {
                bgBtn(btnOffer, btnI)
                findNavController(R.id.discussion_nav_fragment).navigate(R.id.discussionOffer)
            }
            btnI.setOnClickListener {
                bgBtn(btnI, btnOffer)
                findNavController(R.id.discussion_nav_fragment).navigate(R.id.discussionI)
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
//    override fun onBackPressed() {
//
//        when(findNavController(R.id.discussion_nav_fragment).currentDestination?.id)
//        {
//            R.id.discussionOffer->
//            {
//                finish()
//            }
//            R.id.discussionI->
//            {
//                bgBtn(binding.btnOffer,binding.btnI)
//                super.onBackPressed()
//            }
//        }
//
//    }
}