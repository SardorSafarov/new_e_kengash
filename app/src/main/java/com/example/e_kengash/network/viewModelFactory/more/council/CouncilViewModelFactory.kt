package com.example.e_kengash.network.viewModelFactory.more.council

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.repository.more.council.CouncilRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel
import com.example.e_kengash.network.viewModel.more.council.CouncilViewModel


class CouncilViewModelFactory(private val councilRepository: CouncilRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CouncilViewModel(councilRepository) as T
    }
}