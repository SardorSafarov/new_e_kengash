package com.example.e_kengash.main.activity.moreInActivity.article

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.more.article.ArticleAdapter
import com.example.e_kengash.databinding.ActivityArticleBinding
import com.example.e_kengash.network.entity.more.article.New
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.statusbarcolor

class ArticleActivity : AppCompatActivity(),ArticleAdapter.onClickListener {
    private lateinit var moreViewModel: MoreViewModel
    private val adapterArticle:ArticleAdapter by lazy { ArticleAdapter(this) }
    private lateinit var binding:ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        setUi()
        getArticleList()
        back()
    }

    private fun back() {
        binding.back.setOnClickListener {
            finish()
        }
    }

    private fun getArticleList() {
        moreViewModel.articleList()
        moreViewModel.articleList.observe(this, Observer {
            if(it.isSuccessful)
            {
                onResponse(it.body()!!.news)
                binding.progressBar.gone()
            }
            else
            {
                D("ArticleActivity articleList false ${it.errorBody()!!.string()}")
            }
        })
    }

    private fun onResponse(news: List<New>) {
        binding.recList.apply {
            adapter = adapterArticle
            layoutManager = LinearLayoutManager(this@ArticleActivity)
        }
        adapterArticle.setData(news)
    }

    private fun setUi() {
        val articleRepository = MoreRepository()
        val articleViewModelFactory = MoreViewModelFactory(articleRepository)
        val articleViewModel = ViewModelProvider(
            this,
            articleViewModelFactory
        ).get(MoreViewModel::class.java)
        this.moreViewModel = articleViewModel

    }

    override fun setOnClickLister(text: String) {

    }
}