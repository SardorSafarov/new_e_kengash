package com.example.e_kengash.network.viewModel.appealsSend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.appealsSend.district.DistrictResponse
import com.example.e_kengash.network.entity.appealsSend.region.RegionResponse
import com.example.e_kengash.network.entity.appealsSend.type.AppealsSendTypeResponse
import com.example.e_kengash.network.repository.appealsSend.AppealsSendRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class AppealsSendViewModel(private val appealsSendRepository: AppealsSendRepository):ViewModel() {

    fun appealsType(onResponse: (response: Response<AppealsSendTypeResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(appealsSendRepository.appealsType())
            }catch (e:Exception)
            {
                D("AppealsSendViewModel appealsType ${e.message}")
            }
        }
    }


    fun getRegion(onResponse: (response: Response<RegionResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(appealsSendRepository.getRegion())
            }catch (e:Exception)
            {
                D("AppealsSendViewModel getRegion ${e.message}")
            }
        }
    }

    fun getDistict(id:String,onResponse: (response: Response<DistrictResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(appealsSendRepository.getDistict(id))
            }catch (e:Exception)
            {
                D("AppealsSendViewModel getDistict ${e.message}")
            }
        }
    }

    fun getMFY(id:String,onResponse: (response: Response<DistrictResponse>) -> Unit)
    {
        viewModelScope.launch {
            try {
                onResponse(appealsSendRepository.getMFY(id))
            }catch (e:Exception)
            {
                D("AppealsSendViewModel getMFY ${e.message}")
            }
        }
    }


}