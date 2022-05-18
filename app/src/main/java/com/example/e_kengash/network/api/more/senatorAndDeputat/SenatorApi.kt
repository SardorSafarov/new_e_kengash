package com.example.e_kengash.network.api.more.senatorAndDeputat

import com.example.e_kengash.main.activity.moreInActivity.senatorAndDeputat.main.SenatorAndDeputat
import com.example.e_kengash.network.entity.more.senator.SenatorAndDeputatListResponse
import retrofit2.Response
import retrofit2.http.GET

interface SenatorApi {

    @GET("/api/v1/OM-sanators/")
    suspend fun getSenatorList():Response<SenatorAndDeputatListResponse>

    @GET("api/v1/OM-deputies/")
    suspend fun getDeputatList():Response<SenatorAndDeputatListResponse>
}