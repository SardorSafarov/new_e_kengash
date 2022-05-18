package com.example.e_kengash.network.viewModelFactory.more.senator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.more.senator.SenatorRepository
import com.example.e_kengash.network.repository.more.youth.YouthRepository
import com.example.e_kengash.network.viewModel.more.senator.SenatorViewModel
import com.example.e_kengash.network.viewModel.more.youth.YouthViewModel



class SenatorVewModelFactory(private val senatorRepository: SenatorRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SenatorViewModel(senatorRepository) as T
    }
}