package com.example.e_kengash.main.activity.moreInActivity.activities.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.e_kengash.adapter.more.activities.ActivitiesRecommendedAdapter
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityActivitiesAboutBinding
import com.example.e_kengash.network.entity.more.activites.about.Recommended
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.statusbarcolor
import com.example.e_kengash.repetitive.tosatLong

class ActivitiesAbout : AppCompatActivity(), ActivitiesRecommendedAdapter.onClickListener {

    private lateinit var binding: ActivityActivitiesAboutBinding
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    private val adapterRecommended: ActivitiesRecommendedAdapter by lazy {
        ActivitiesRecommendedAdapter(
            this,
            applicationContext,
            sharePereferenseHelper.getAccessDomen2()
        )
    }
    lateinit var moreViewModel: MoreViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper((this))
        statusbarcolor(Color.WHITE)
        moreSetUi()
        back()
        binding.apply {
            intent.apply {
                modifiedDate.text = getStringExtra("date")
                content.text = Html.fromHtml(getStringExtra("content"))
                title.text = getStringExtra("title")
                Glide.with(applicationContext).load(getStringExtra("image")).into(image)
            }
        }
        loadRecommended()
    }

    private fun loadRecommended() {
        moreViewModel.activitesAbout(intent.getStringExtra("id").toString())
        {
            when (it.isSuccessful) {
                true -> {
                    adapterRecommended(it.body()!!.recommended)
                }
                else -> {}
            }
        }
    }

    private fun adapterRecommended(recommended: List<Recommended>) {
        when (recommended.isEmpty()) {
            true -> {
                tosatLong(this, "Tavsiyalar yo`q!!")
            }
            else -> {
                binding.apply {
                    recListRecommonded.apply {
                        adapter = adapterRecommended
                        layoutManager = LinearLayoutManager(this@ActivitiesAbout,LinearLayoutManager.HORIZONTAL,false)
                    }
                }
                adapterRecommended.setData(recommended)
            }
        }
    }

    private fun moreSetUi() {
        val moreRepository = MoreRepository()
        val moreVewModelFactory = MoreViewModelFactory(moreRepository)
        val moreViewModel = ViewModelProvider(
            this,
            moreVewModelFactory
        ).get(MoreViewModel::class.java)
        this.moreViewModel = moreViewModel
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

    override fun itemSetOnClickLister(id: String) {

    }
}