package com.example.e_kengash.main.activity.strem

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.example.e_kengash.databinding.ActivityLiveSteamBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
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
        youtobe()
    }

    private fun youtobe() {
        yy=object :YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo("L0WGZSiOZsM")
                when(p2)
                {
                    false-> binding.progressBar.invisible()
                }
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
               tosatShort(this@LiveSteamActivity,"Error")
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