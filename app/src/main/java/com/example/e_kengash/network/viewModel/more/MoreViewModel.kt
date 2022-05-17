package com.example.e_kengash.network.viewModel.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.getDomen.GetDomenResponse
import com.example.e_kengash.network.entity.more.article.ArticleResponse
import com.example.e_kengash.network.entity.more.secretariat.region.SecRegionResponse
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class MoreViewModel(private val moreRepository: MoreRepository): ViewModel() {

    fun getDomen(onResponse:(response:Response<GetDomenResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.getDomen())
            }catch (e:Exception)
            {
                D("MoreViewModel getDomen  ${e.message}")
            }
        }
    }

     val articleList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()
     val newsList:MutableLiveData<Response<ArticleResponse>> = MutableLiveData()

    fun articleList()
    {
        viewModelScope.launch {
            try {
               articleList.value = moreRepository.articleList()
            }catch (e:Exception)
            {
                D("MoreViewModel articleList  ${e.message}")
            }
        }
    }

    fun newsList()
    {
        viewModelScope.launch {
            try {
                newsList.value = moreRepository.newsList()
            }catch (e:Exception)
            {
                D("MoreViewModel newsList  ${e.message}")
            }
        }
    }

    fun secRegionList(onResponse:(response:Response<SecRegionResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
               onResponse(moreRepository.secRegionList())
            }catch (e:Exception)
            {
                D("MoreViewModel secRegionList  ${e.message}")
            }
        }
    }

    fun secDistrictList(onResponse:(response:Response<SecRegionResponse>)->Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(moreRepository.secDistrictList())
            }catch (e:Exception)
            {
                D("MoreViewModel secDistrictList  ${e.message}")
            }
        }
    }


}