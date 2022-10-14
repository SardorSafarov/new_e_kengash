package com.example.e_kengash.main.activity.moreInActivity.profil.main

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityProfilBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.login.webView.LoginWebActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class ProfilActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProfilBinding
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
        statusbarcolor(Color.WHITE)
        back()
        notification()
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