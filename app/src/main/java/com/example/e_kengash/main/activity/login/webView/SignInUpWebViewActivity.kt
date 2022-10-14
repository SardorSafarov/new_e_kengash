package com.example.e_kengash.main.activity.login.webView

import android.graphics.Color
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.e_kengash.data.LocalVarable.URL_KEY_ID
import com.example.e_kengash.databinding.ActivitySignInUpWebViewBinding
import com.example.e_kengash.repetitive.D
import org.jsoup.Jsoup


class SignInUpWebViewActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignInUpWebViewBinding
    var a= true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInUpWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.parseColor("#ffffff")
        val urlString =
            "https://sso.egov.uz/sso/oauth/Authorization.do?scope=it_education_leader&redirect_uri=https%3A%2F%2Fe-kengash.uz%2Fuser%2Fone-id%2F2%2F&client_id=it_education_leader&state=testState&response_type=one_code"
        binding.apply {
            webView.settings.domStorageEnabled = true
            webView.getSettings().setPluginState(WebSettings.PluginState.ON)
            webView.getSettings().setJavaScriptEnabled(true)
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false)
            webView.getSettings().setSupportMultipleWindows(false)
            webView.getSettings().setSupportZoom(false)
            webView.setVerticalScrollBarEnabled(false)
            webView.setHorizontalScrollBarEnabled(false)
            webView.webViewClient = WebViewClient()
            webView.loadUrl(urlString)
            webView.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    if (view.url!!.contains("https://e-kengash.uz/user/one-id")) {
                        URL_KEY_ID = view.url.toString()
                        finish()
                    }
                }
            }
        }


    }
}