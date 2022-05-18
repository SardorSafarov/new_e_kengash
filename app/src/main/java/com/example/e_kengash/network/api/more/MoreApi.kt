package com.example.e_kengash.network.api.more

import com.example.e_kengash.network.entity.getDomen.GetDomenResponse
import com.example.e_kengash.network.entity.more.article.ArticleResponse
import com.example.e_kengash.network.entity.more.secretariat.changeDeputat.SecretariatChangeDeputatDataResponse
import com.example.e_kengash.network.entity.more.secretariat.data.SecretariatDataListResponse
import com.example.e_kengash.network.entity.more.secretariat.region.SecRegionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoreApi {

    @GET("/api/v1/get-domen")
    suspend fun getDomen():Response<GetDomenResponse>


    @GET("/api/v1/articles")
    suspend fun articleList():Response<ArticleResponse>

    @GET("/api/v1/news")
    suspend fun newsList():Response<ArticleResponse>

    @GET("/api/v1/secretariat-region")
    suspend fun secretariatRegionList():Response<SecRegionResponse>

    @GET("/api/v1/secretariat-district")
    suspend fun secretariatDistrictList():Response<SecRegionResponse>

    @GET("/api/v1/secretariat-info/")
    suspend fun secretariatDataList():Response<SecretariatDataListResponse>

    @GET("/api/v1/secretariat/{id}/info/")
    suspend fun secretariatChangeDeputatData(@Path("id")id:String):Response<SecretariatChangeDeputatDataResponse>

}