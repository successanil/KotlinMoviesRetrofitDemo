/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.relsellglobal.moviesretrofitdemo.businesslogic.models.Product
import com.relsellglobal.moviesretrofitdemo.repository.ProductsListRepository
import kotlinx.coroutines.launch

class ProductsListFragmentViewModel(private val productsListRepository: ProductsListRepository) : ViewModel() {

    suspend fun getProducts() : MutableLiveData<List<Product>> = productsListRepository.fetchProducts()
}