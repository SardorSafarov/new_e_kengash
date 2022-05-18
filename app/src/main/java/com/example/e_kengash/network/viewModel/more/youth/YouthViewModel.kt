package com.example.e_kengash.network.viewModel.more.youth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.more.youth.data.YouthDataResponse
import com.example.e_kengash.network.entity.more.youth.deputat.YouthDeputatResponse
import com.example.e_kengash.network.repository.more.youth.YouthRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class YouthViewModel(private val youthRepository: YouthRepository) : ViewModel() {

    fun getData(onResponse: (response: Response<YouthDataResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(youthRepository.getData())
            } catch (e: Exception) {
                D("YouthViewModel getData ".plus(e.message))
            }
        }
    }

    fun getDeputatList(onResponse: (response: Response<YouthDeputatResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(youthRepository.getDeputatList())
            } catch (e: Exception) {
                D("YouthViewModel getDeputatList ".plus(e.message))
            }
        }
    }
    fun changeDeputatData(id:String,onResponse: (response: Response<YouthDeputatResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(youthRepository.changeDeputatData(id))
            } catch (e: Exception) {
                D("YouthViewModel changeDeputatData ".plus(e.message))
            }
        }
    }
}