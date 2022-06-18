package com.relsellglobal.moviesretrofitdemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.relsellglobal.moviesretrofitdemo.repository.ProductsListRepository
import javax.inject.Inject

class ProductViewModelFactory @Inject constructor(private val productsListRepository: ProductsListRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductsListFragmentViewModel(productsListRepository) as T
    }
}