package com.example.e_kengash.splashScreen

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.e_kengash.R
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.main.activity.mainActivity.MainActivity
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
    //*======لا اله الا الله محمد رسول الله
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharePereferenseHelper = SharePereferenseHelper(this)
        setApplicationLocale(sharePereferenseHelper.getAccessLenguage())
        startActivity(Intent(this,MainActivity::class.java))
    }
    private fun setApplicationLocale(locale: String) {
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