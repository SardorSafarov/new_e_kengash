package com.example.e_kengash.network.viewModel.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.article.ArticleResponse
import com.example.e_kengash.network.entity.login.register.RegisterUserRequest
import com.example.e_kengash.network.entity.login.register.RegisterUserResponse
import com.example.e_kengash.network.repository.ArticleRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class ArticleViewModel(private val articleRepository: ArticleRepository): ViewModel() {

     val articleList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()

    fun articleList()
    {
        viewModelScope.launch {
            try {
               articleList.value = articleRepository.articleList()
            }catch (e:Exception)
            {
                D("LoginViewModel registerUser  ${e.message}")
            }
        }
    }
}