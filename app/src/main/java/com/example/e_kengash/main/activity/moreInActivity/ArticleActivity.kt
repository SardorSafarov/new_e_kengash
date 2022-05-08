package com.example.e_kengash.main.activity.moreInActivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.adapter.article.ArticleAdapter
import com.example.e_kengash.databinding.ActivityArticleBinding
import com.example.e_kengash.network.entity.article.New
import com.example.e_kengash.network.repository.ArticleRepository
import com.example.e_kengash.network.viewModel.article.ArticleViewModel
import com.example.e_kengash.network.viewModelFactory.article.ArticleViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.statusbarcolor

class ArticleActivity : AppCompatActivity(),ArticleAdapter.onClickListener {
    private lateinit var articleViewModel: ArticleViewModel
    private val adapterArticle:ArticleAdapter by lazy { ArticleAdapter(this) }
    private lateinit var binding:ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        setUi()
        getArticleList()
    }

    private fun getArticleList() {
        articleViewModel.articleList()
        articleViewModel.articleList.observe(this, Observer {
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
        val articleRepository = ArticleRepository()
        val articleViewModelFactory = ArticleViewModelFactory(articleRepository)
        val articleViewModel = ViewModelProvider(
            this,
            articleViewModelFactory
        ).get(ArticleViewModel::class.java)
        this.articleViewModel = articleViewModel

    }

    override fun setOnClickLister(text: String) {

    }
}