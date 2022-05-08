package com.example.e_kengash.network.api.more.article

import com.example.e_kengash.network.entity.article.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticleApi {
    @GET("/api/v1/articles")
    suspend fun articleList():Response<ArticleResponse>
}