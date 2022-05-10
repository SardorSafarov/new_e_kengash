package com.example.e_kengash.network.api.appealsSend

import com.example.e_kengash.network.entity.appealsSend.district.DistrictResponse
import com.example.e_kengash.network.entity.appealsSend.region.RegionResponse
import com.example.e_kengash.network.entity.appealsSend.type.AppealsSendTypeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

interface AppealsSendApi {
    @GET("/api/v1/appeal-direction/")
    suspend fun appealsType():Response<AppealsSendTypeResponse>

    @GET("/api/v1/address/")
    suspend fun getRegion():Response<RegionResponse>

    @GET("/api/v1/address")
    suspend fun getDistict(@Query("sub")id:String):Response<DistrictResponse>


    @GET("/api/v1/address?sub={id}")
    suspend fun getMFY(@Part("id")id:String):Response<DistrictResponse>
}