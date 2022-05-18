package com.example.e_kengash.network.api.more.youth

import com.example.e_kengash.network.entity.more.youth.changeDeputat.YouthChangeDeputatDataResponse
import com.example.e_kengash.network.entity.more.youth.data.YouthDataResponse
import com.example.e_kengash.network.entity.more.youth.deputat.YouthDeputatResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface YouthApi {

    @GET("/api/v1/youth-parliament-info/")
    suspend fun getDataList():Response<YouthDataResponse>

    @GET("/api/v1/youth-parliament-deputies/")
    suspend fun getDeputatList():Response<YouthDeputatResponse>

    @GET("/api/v1/youth-parliament-deputy/{id}/")
    suspend fun changeDeputatData(@Path("id")id:String):Response<YouthChangeDeputatDataResponse>
}