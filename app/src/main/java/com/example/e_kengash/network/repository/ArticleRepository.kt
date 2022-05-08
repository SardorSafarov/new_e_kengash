package com.example.e_kengash.network.repository

import com.example.e_kengash.network.entity.article.ArticleResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class ArticleRepository {
    suspend fun articleList():Response<ArticleResponse> = RetrofitBuilder().articleApi.articleList()
}