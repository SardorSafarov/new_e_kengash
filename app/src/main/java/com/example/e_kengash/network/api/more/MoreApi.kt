package com.example.e_kengash.network.api.more

import com.example.e_kengash.network.entity.article.ArticleResponse
import com.example.e_kengash.network.entity.secretariat.region.SecRegionResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoreApi {
    @GET("/api/v1/articles")
    suspend fun articleList():Response<ArticleResponse>

    @GET("/api/v1/news")
    suspend fun newsList():Response<ArticleResponse>

    @GET("/api/v1/secretariat-region")
    suspend fun secretariatDataList():Response<SecRegionResponse>

    @GET("/api/v1/secretariat-district")
    suspend fun secDistrictList():Response<SecRegionResponse>
}