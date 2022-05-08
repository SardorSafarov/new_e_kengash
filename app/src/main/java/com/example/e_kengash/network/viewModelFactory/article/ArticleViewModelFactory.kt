package com.example.e_kengash.network.viewModelFactory.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.ArticleRepository
import com.example.e_kengash.network.repository.login.LoginRepository
import com.example.e_kengash.network.viewModel.article.ArticleViewModel
import com.example.e_kengash.network.viewModel.login.LoginViewModel



class ArticleViewModelFactory(private val articleRepository: ArticleRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(articleRepository) as T
    }
}