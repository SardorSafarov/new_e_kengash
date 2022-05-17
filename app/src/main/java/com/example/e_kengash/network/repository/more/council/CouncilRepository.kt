package com.example.e_kengash.network.repository.more.council

import com.example.e_kengash.network.entity.more.council.changeDeputat.article.ChangeDeputatArticle
import com.example.e_kengash.network.entity.more.council.changeDeputat.info.ChangeDeputatInfoResponse
import com.example.e_kengash.network.entity.more.council.data.CouncilDataResponse
import com.example.e_kengash.network.entity.more.council.deputat.CouncilDeputatListResponse
import com.example.e_kengash.network.retrofitBuilder.RetrofitBuilder
import retrofit2.Response

class CouncilRepository {

    suspend fun getDeputatList(): Response<CouncilDeputatListResponse> =
        RetrofitBuilder().councilApi.getDeputatList()

    suspend fun getDataList(): Response<CouncilDataResponse> =
        RetrofitBuilder().councilApi.getDataList()

    suspend fun changeDeputatInfo(id:String): Response<ChangeDeputatInfoResponse> =
        RetrofitBuilder().councilApi.changeDeputatInfo(id)

    suspend fun changeDeputatArticle(id:String): Response<ChangeDeputatArticle> =
        RetrofitBuilder().councilApi.changeDeputatArticle(id)
}