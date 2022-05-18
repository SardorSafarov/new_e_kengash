package com.example.e_kengash.network.repository.more.youth

import com.example.e_kengash.network.entity.more.youth.data.YouthDataResponse
import com.example.e_kengash.network.entity.more.youth.deputat.YouthDeputatResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class YouthRepository {

    suspend fun getData():Response<YouthDataResponse> =RetrofitBuilder().youthApi.getDataList()

    suspend fun getDeputatList():Response<YouthDeputatResponse> =RetrofitBuilder().youthApi.getDeputatList()

    suspend fun changeDeputatData(id:String):Response<YouthDeputatResponse> =RetrofitBuilder().youthApi.changeDeputatData(id)
}