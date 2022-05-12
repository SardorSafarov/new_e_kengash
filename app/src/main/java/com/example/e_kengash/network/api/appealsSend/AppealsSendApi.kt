package com.example.e_kengash.network.api.appealsSend

import com.example.e_kengash.network.entity.appealsSend.district.DistrictResponse
import com.example.e_kengash.network.entity.appealsSend.myAppealsSend.request.MyAppealsSendRequest
import com.example.e_kengash.network.entity.appealsSend.myAppealsSend.response.MyAppealsSendResponse
import com.example.e_kengash.network.entity.appealsSend.region.RegionResponse
import com.example.e_kengash.network.entity.appealsSend.type.AppealsSendTypeResponse
import retrofit2.Response
import retrofit2.http.*

interface AppealsSendApi {
    @GET("/api/v1/appeal-direction/")
    suspend fun appealsType():Response<AppealsSendTypeResponse>

    @GET("/api/v1/address/")
    suspend fun getRegion():Response<RegionResponse>

    @GET("/api/v1/address")
    suspend fun getDistict(@Query("sub")id:String):Response<DistrictResponse>


    @GET("/api/v1/address")
    suspend fun getMFY(@Query("sub")id:String):Response<DistrictResponse>


    @POST("/api/v1/appeal-send/")
    suspend fun myAppealsSend(@Header("Authorization")token: String, @Body body: MyAppealsSendRequest):Response<MyAppealsSendResponse>


}