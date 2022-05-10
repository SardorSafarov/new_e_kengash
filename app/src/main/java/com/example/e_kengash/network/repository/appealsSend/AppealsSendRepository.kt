package com.example.e_kengash.network.repository.appealsSend

import com.example.e_kengash.network.entity.appealsSend.district.DistrictResponse
import com.example.e_kengash.network.entity.appealsSend.region.RegionResponse
import com.example.e_kengash.network.entity.appealsSend.type.AppealsSendTypeResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class AppealsSendRepository {
    suspend fun appealsType(): Response<AppealsSendTypeResponse> = RetrofitBuilder().appealsSendApi.appealsType()

    suspend fun getRegion(): Response<RegionResponse> = RetrofitBuilder().appealsSendApi.getRegion()

    suspend fun getDistict(id:String): Response<DistrictResponse> = RetrofitBuilder().appealsSendApi.getDistict(id)

    suspend fun getMFY(id:String): Response<DistrictResponse> = RetrofitBuilder().appealsSendApi.getMFY(id)
}