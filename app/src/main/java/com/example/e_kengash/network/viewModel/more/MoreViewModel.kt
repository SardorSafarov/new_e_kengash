package com.example.e_kengash.network.viewModel.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.article.ArticleResponse
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class MoreViewModel(private val moreRepository: MoreRepository): ViewModel() {

     val articleList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()
     val newsList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()

    fun articleList()
    {
        viewModelScope.launch {
            try {
               articleList.value = moreRepository.articleList()
            }catch (e:Exception)
            {
                D("LoginViewModel registerUser  ${e.message}")
            }
        }
    }

    fun newsList()
    {
        viewModelScope.launch {
            try {
                newsList.value = moreRepository.newsList()
            }catch (e:Exception)
            {
                D("LoginViewModel newsList  ${e.message}")
            }
        }
    }
}