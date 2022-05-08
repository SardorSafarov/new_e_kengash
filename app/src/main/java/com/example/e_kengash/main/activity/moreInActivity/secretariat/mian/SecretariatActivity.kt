package com.example.e_kengash.main.activity.moreInActivity.secretariat.mian

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.findNavController
import com.example.e_kengash.R
import com.example.e_kengash.adapter.appeal.AppealsTopMenuAdapter
import com.example.e_kengash.databinding.ActivitySecritariatBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.repetitive.statusbarcolor

class SecretariatActivity : AppCompatActivity(), AppealsTopMenuAdapter.onClickListener {
    private lateinit var binding: ActivitySecritariatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecritariatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        back()
        notification()
        navigationFragment()
    }


    private fun navigationFragment() {
        binding.apply {
            btnData.setOnClickListener {
                bgBtn(btnData, btnRegion, btnDictirct)
                findNavController(R.id.secretariat_nav_fragment).navigate(R.id.secretariatInfo)
            }
            btnRegion.setOnClickListener {
                bgBtn(btnRegion, btnData, btnDictirct)
                findNavController(R.id.secretariat_nav_fragment).navigate(R.id.secretariatRegion)
            }
            btnDictirct.setOnClickListener {
                bgBtn(btnDictirct, btnRegion, btnData)
                findNavController(R.id.secretariat_nav_fragment).navigate(R.id.secretariatDistrict)
            }
        }
    }

    private fun bgBtn(
        btn1: AppCompatTextView,
        btn2: AppCompatTextView,
        btn3: AppCompatTextView
    ) {
        btn1.apply {
            setBackgroundResource(R.drawable.bg_text_blue)
            setTextColor(resources.getColor(R.color.white))
        }
        btn2.apply {
            setBackgroundResource(R.color.white)
            setTextColor(resources.getColor(R.color.gray))
        }
        btn3.apply {
            setBackgroundResource(R.color.white)
            setTextColor(resources.getColor(R.color.gray))
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

    override fun setOnClickLister(text: String) {

    }
}