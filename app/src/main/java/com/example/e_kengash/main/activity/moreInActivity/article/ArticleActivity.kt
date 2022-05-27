package com.example.e_kengash.main.activity.moreInActivity.article

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_kengash.R
import com.example.e_kengash.adapter.more.article.ArticleAdapter
import com.example.e_kengash.data.localMemory.SharePereferenseHelper
import com.example.e_kengash.databinding.ActivityArticleBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.notif.NotificationActivity
import com.example.e_kengash.network.entity.more.article.New
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModelFactory.more.MoreViewModelFactory
import com.example.e_kengash.repetitive.D
import com.example.e_kengash.repetitive.invisible
import com.example.e_kengash.repetitive.statusbarcolor

class ArticleActivity : AppCompatActivity(),ArticleAdapter.onClickListener {
    private lateinit var moreViewModel: MoreViewModel
    private val adapterArticle:ArticleAdapter by lazy { ArticleAdapter(this) }
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    private lateinit var binding:ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusbarcolor(Color.WHITE)
        sharePereferenseHelper = SharePereferenseHelper(this)
        setUi()
        getArticleList()
        back()
        notification()
    }
    private fun notification() {
        binding.notification.setOnClickListener {
            when (sharePereferenseHelper.getAccessToken()) {
                "empty" -> {
                    signUp()
                }
                else -> {
                    startActivity(Intent(this, NotificationActivity::class.java))
                }
            }

        }
    }

    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(this, R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(this).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
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
            }
            else
            {
                D("ArticleActivity articleList false ${it.errorBody()!!.string()}")
            }
        })
    }

    private fun onResponse(news: List<New>) {
        binding.progressBar.invisible()
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