package com.example.e_kengash.network.viewModel.more.council


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.more.council.CouncilDistrictListResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.activity.ChangeDeputatActivityResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.article.ChangeDeputatArticleResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.doc.ChangeDeputatDocResponse
import com.example.e_kengash.network.entity.more.council.changeDeputat.info.ChangeDeputatInfoResponse
import com.example.e_kengash.network.entity.more.council.data.CouncilDataResponse
import com.example.e_kengash.network.entity.more.council.deputat.CouncilDeputatListResponse
import com.example.e_kengash.network.repository.more.council.CouncilRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class CouncilViewModel(private val councilRepository: CouncilRepository) : ViewModel() {


    fun councilDeputatList(onResponse: (response: Response<CouncilDeputatListResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.getDeputatList())
            } catch (e: Exception) {
                D("CouncilViewModel  councilDeputatList  ${e.message}")
            }
        }
    }

    fun getDataList(onResponse: (response: Response<CouncilDataResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.getDataList())
            } catch (e: Exception) {
                D("CouncilViewModel  getDataList  ${e.message}")
            }
        }
    }

    fun changeDeputatInfo(
        id: String,
        onResponse: (response: Response<ChangeDeputatInfoResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.changeDeputatInfo(id))
            } catch (e: Exception) {
                D("CouncilViewModel  changeDeputatInfo  ${e.message}")
            }
        }
    }

    fun changeDeputatArticle(
        id: String,
        onResponse: (response: Response<ChangeDeputatArticleResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.changeDeputatArticle(id))
            } catch (e: Exception) {
                D("CouncilViewModel  changeDeputatArticle  ${e.message}")
            }
        }
    }

    fun changeDeputatActivity(
        id: String,
        onResponse: (response: Response<ChangeDeputatActivityResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.changeDeputatActivity(id))
            } catch (e: Exception) {
                D("CouncilViewModel  changeDeputatActivity  ${e.message}")
            }
        }
    }

    fun changeDeputatDoc(
        id: String,
        onResponse: (response: Response<ChangeDeputatDocResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.changeDeputatDoc(id))
            } catch (e: Exception) {
                D("CouncilViewModel  changeDeputatDoc  ${e.message}")
            }
        }
    }

    fun getDistrict(
        onResponse: (response: Response<CouncilDistrictListResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                onResponse(councilRepository.getDistrict())
            } catch (e: Exception) {
                D("CouncilViewModel  getDistrict  ${e.message}")
            }
        }
    }
}