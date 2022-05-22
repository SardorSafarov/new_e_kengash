package com.example.e_kengash.network.api.more.concil

import com.example.e_kengash.network.entity.more.council.CouncilDistrictListResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.activity.ChangeDeputatActivityResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.article.ChangeDeputatArticleResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.doc.ChangeDeputatDocResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.info.ChangeDeputatInfoResponse
import com.example.e_kengash.network.entity.more.council.data.CouncilDataResponse
import com.example.e_kengash.network.entity.more.council.deputat.CouncilDeputatListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CouncilApi {
    @GET("/api/v1/council-deputies")
    suspend fun getDeputatList(): Response<CouncilDeputatListResponse>

    @GET("/api/v1/council-info")
    suspend fun getDataList(): Response<CouncilDataResponse>

    @GET("/api/v1/deputy/{id}/info/")
    suspend fun changeDeputatInfo(@Path("id") id:String):Response<ChangeDeputatInfoResponse>

    @GET("/api/v1/deputy/{id}/articles/")
    suspend fun changeDeputatArticle(@Path("id") id:String):Response<ChangeDeputatArticleResponse>

    @GET("/api/v1/deputy/{id}/events/")
    suspend fun changeDeputatActivity(@Path("id") id:String):Response<ChangeDeputatActivityResponse>

    @GET("/api/v1/deputy/{id}/docs/")
    suspend fun changeDeputatDoc(@Path("id") id:String):Response<Any>


    @GET("api/v1/council-district")
    suspend fun getDistrict():Response<CouncilDistrictListResponse>

}