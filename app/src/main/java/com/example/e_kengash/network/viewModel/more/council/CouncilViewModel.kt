package com.example.e_kengash.network.viewModel.more.council


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.more.council.changeDeputat.article.ChangeDeputatArticle
import com.example.e_kengash.network.entity.more.council.changeDeputat.info.ChangeDeputatInfoResponse
import com.example.e_kengash.network.entity.more.council.data.CouncilDataResponse
import com.example.e_kengash.network.entity.more.council.deputat.CouncilDeputatListResponse
import com.example.e_kengash.network.repository.more.council.CouncilRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import okhttp3.internal.Util
import retrofit2.Response

class CouncilViewModel(private val councilRepository: CouncilRepository): ViewModel() {



    fun councilDeputatList(onResponse: (response: Response<CouncilDeputatListResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.getDeputatList())
            }catch (e:Exception)
            {
                D("CouncilViewModel  councilDeputatList  ${e.message}")
            }
        }
    }

    fun getDataList(onResponse: (response: Response<CouncilDataResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.getDataList())
            }catch (e:Exception)
            {
                D("CouncilViewModel  getDataList  ${e.message}")
            }
        }
    }

    fun changeDeputatInfo(id:String,onResponse: (response: Response<ChangeDeputatInfoResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.changeDeputatInfo(id))
            }catch (e:Exception)
            {
                D("CouncilViewModel  changeDeputatInfo  ${e.message}")
            }
        }
    }

    fun changeDeputatArticle(id:String,onResponse: (response: Response<ChangeDeputatArticle>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.changeDeputatArticle(id))
            }catch (e:Exception)
            {
                D("CouncilViewModel  changeDeputatInfo  ${e.message}")
            }
        }
    }
}