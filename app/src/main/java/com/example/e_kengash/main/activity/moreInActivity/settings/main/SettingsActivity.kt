package com.example.e_kengash.main.activity.moreInActivity.settings.main

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivitySettingsBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.BottomSheetLanguageBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.login.webView.LoginWebActivity
import com.example.e_kengash.main.activity.mainActivity.MainActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor
import com.example.e_kengash.repetitive.tosatLong
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var bottomSheetDiaolg: BottomSheetDialog
    private lateinit var sharedPreferences: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        sharedPreferences = SharePereferenseHelper(this)
        back()
        notification()
        notif()
        kesh()
        language()
    }
    private fun kesh() {
        when (binding.kesh.isChecked) {
            true -> {
            }
            else -> {

            }
        }
    }
    private fun notif() {
        when (binding.notif.isChecked) {
            true -> {
            }
            else -> {
            }
        }
    }
    private fun notification() {
        binding.notification.setOnClickListener {
            when (sharedPreferences.getAccessToken()) {
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

    private fun language() {
        binding.language.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottom_sheet_language, null)
            bottomSheetDiaolg = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val bottomSheetBind = BottomSheetLanguageBinding.bind(view)
            bottomSheetDiaolg.apply {
                setContentView(view)
                show()
            }
            bottomSheetBind.apply {
                uz.setOnClickListener {
                    sharedPreferences.setAccessLanguage("uz")
                    setApplicationLanguage("uz")
                    bottomSheetDiaolg.dismiss()
                    startActivity(Intent(this@SettingsActivity, MainActivity::class.java))
                    finishAffinity()
                }
                ru.setOnClickListener {
                    sharedPreferences.setAccessLanguage("ru")
                    setApplicationLanguage("ru")
                    bottomSheetDiaolg.dismiss()
                    startActivity(Intent(this@SettingsActivity,MainActivity::class.java))
                    finishAffinity()
                }
                en.setOnClickListener {
                  sharedPreferences.setAccessLanguage("en-us")
                    setApplicationLanguage("en-us")
                    bottomSheetDiaolg.dismiss()
                    startActivity(Intent(this@SettingsActivity,MainActivity::class.java))
                    finishAffinity()
                }
            }

        }
    }

    private fun setApplicationLanguage(locale: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(locale.toLowerCase()))
        } else {
            config.locale = Locale(locale.toLowerCase())
        }
        resources.updateConfiguration(config, dm)
    }
}