package com.example.e_kengash.network.repository.more

import com.example.e_kengash.network.entity.getDomen.GetDomenResponse
import com.example.e_kengash.network.entity.more.article.ArticleResponse
import com.example.e_kengash.network.entity.more.secretariat.region.SecRegionResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class MoreRepository {

    suspend fun getDomen():Response<GetDomenResponse> = RetrofitBuilder().moreApi.getDomen()

    suspend fun articleList():Response<ArticleResponse> = RetrofitBuilder().moreApi.articleList()

    suspend fun newsList():Response<ArticleResponse> = RetrofitBuilder().moreApi.newsList()

     suspend fun secRegionList():Response<SecRegionResponse> = RetrofitBuilder().moreApi.secretariatDataList()

     suspend fun secDistrictList():Response<SecRegionResponse> = RetrofitBuilder().moreApi.secDistrictList()
}