package com.example.e_kengash.main.activity.search

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.article.ArticleAdapter
import com.example.e_kengash.databinding.ActivitySearchBinding
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.network.entity.more.article.New
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.statusbarcolor
import com.example.e_kengash.repetitive.tosatLong

class SearchActivity : AppCompatActivity(), ArticleAdapter.onClickListener {

    private lateinit var binding: ActivitySearchBinding
    lateinit var moreViewModel: MoreViewModel
    private val adapterArticle: ArticleAdapter by lazy { ArticleAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moreSetUi()
        statusbarcolor(Color.WHITE)
        back()
        notification()
        searchView()
    }

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                moreViewModel.searchMani(p0!!) {
                    when (it.isSuccessful) {
                        true -> {
                            onResponse(it.body()!!.news)
                        }
                        else -> {
                            tosatLong(applicationContext, "Serverda xatolik!!")
                            D("SearchActivity searchMani ".plus(it.errorBody()!!.string()))
                        }
                    }
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return false
            }
        })
    }


    private fun onResponse(news: List<New>) {
        binding.recList.apply {
            adapter = adapterArticle
            layoutManager = LinearLayoutManager(applicationContext)
        }
        adapterArticle.setData(news)
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

    private fun notification() {
        binding.notification.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
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

    override fun setOnClickLister(text: String) {

    }
}