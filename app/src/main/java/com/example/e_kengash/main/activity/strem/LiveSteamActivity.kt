package com.example.e_kengash.main.activity.strem

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.e_kengash.databinding.ActivityLiveSteamBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor
import com.example.e_kengash.repetitive.tosatShort
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class LiveSteamActivity : YouTubeBaseActivity() {
    private lateinit var binding:ActivityLiveSteamBinding
    val youtube_key ="AIzaSyCOPh87y68rS6y0yclrgcbTogPaBQpaZEs"
    private lateinit var y:YouTubePlayerView
    lateinit var yy:YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityLiveSteamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        webView()
    }

    private fun webView() {
        yy=object :YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo("L0WGZSiOZsM")
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
               tosatShort(this@LiveSteamActivity,"keldiii")
            }
        }
        binding.apply {
            youtube.initialize(youtube_key,yy)
        }
    }

    private fun notification() {
        binding.notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }
}