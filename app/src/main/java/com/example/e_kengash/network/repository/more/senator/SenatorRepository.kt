package com.example.e_kengash.network.repository.more.senator

import com.example.e_kengash.network.entity.more.senator.SenatorAndDeputatListResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class SenatorRepository {

    suspend fun getSenatorList():Response<SenatorAndDeputatListResponse> = RetrofitBuilder().senatorApi.getSenatorList()

    suspend fun getDeputatList():Response<SenatorAndDeputatListResponse> = RetrofitBuilder().senatorApi.getDeputatList()
}