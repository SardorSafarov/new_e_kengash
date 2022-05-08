package com.example.e_kengash.network.viewModelFactory.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.e_kengash.network.repository.more.MoreRepository
import com.example.e_kengash.network.viewModel.more.MoreViewModel


class MoreViewModelFactory(private val moreRepository: MoreRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoreViewModel(moreRepository) as T
    }
}