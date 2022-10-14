package com.example.e_kengash.main.activity.login.webView

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.e_kengash.data.LocalVarable.URL_KEY_ID
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityLoginWebViewBinding
import com.example.e_kengash.main.activity.mainActivity.MainActivity
import com.example.e_kengash.network.entity.keyId.KeyId
import com.example.e_kengash.repetitive.D
import com.google.gson.Gson
import org.jsoup.Jsoup

class LoginWebActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginWebViewBinding
    val sharePereferenseHelper: SharePereferenseHelper by lazy { SharePereferenseHelper(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.parseColor("#ffffff")
                startActivity(Intent(this@LoginWebActivity, SignInUpWebViewActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        if (URL_KEY_ID != "") {
            Thread {
                val builder = StringBuilder()
                try {
                    val url = URL_KEY_ID
                    val doc = Jsoup.connect(url).ignoreContentType(true).get()
                    val body = doc.body()
                    builder.append(body.text())
                    var a = Gson().fromJson(builder.toString(), KeyId::class.java)
                   sharePereferenseHelper.setAccessToken(a.key_id)
                    startActivity(Intent(this,MainActivity::class.java))
                    finishAffinity()
                } catch (e: Exception) {
                    builder.append("Error : ").append(e.message).append("\n")
                }
            }.start()
        }
    }
}