package com.example.e_kengash.network.viewModel.more.senator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_kengash.network.entity.more.senator.SenatorAndDeputatListResponse
import com.example.e_kengash.network.repository.more.senator.SenatorRepository
import com.example.e_kengash.repetitive.D
import kotlinx.coroutines.launch
import retrofit2.Response

class SenatorViewModel(private val senatorRepository: SenatorRepository):ViewModel() {


    fun getSenatorList(onResponse: (response: Response<SenatorAndDeputatListResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(senatorRepository.getSenatorList())
            } catch (e: Exception) {
                D("SenatorViewModel  getSenatorList  ${e.message}")
            }
        }
    }

    fun getDeputatList(onResponse: (response: Response<SenatorAndDeputatListResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                onResponse(senatorRepository.getDeputatList())
            } catch (e: Exception) {
                D("SenatorViewModel  getDeputatList  ${e.message}")
            }
        }
    }

}