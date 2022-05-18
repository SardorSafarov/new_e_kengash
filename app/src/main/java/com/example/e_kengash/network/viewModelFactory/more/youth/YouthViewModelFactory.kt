package com.example.e_kengash.network.viewModelFactory.more.youth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.more.council.CouncilRepository
import com.example.e_kengash.network.repository.more.youth.YouthRepository
import com.example.e_kengash.network.viewModel.more.council.CouncilViewModel
import com.example.e_kengash.network.viewModel.more.youth.YouthViewModel


class YouthViewModelFactory(private val youthRepository: YouthRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return YouthViewModel(youthRepository) as T
    }
}