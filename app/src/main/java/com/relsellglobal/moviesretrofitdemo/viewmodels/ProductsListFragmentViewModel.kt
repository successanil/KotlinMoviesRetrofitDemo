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

    lateinit var productList : MutableLiveData<List<Product>>


//    init {
//        viewModelScope.launch {
//            productList = productsListRepository.fetchProducts()
//            println()
//        }
//    }

    suspend fun getProducts() : MutableLiveData<List<Product>> {
        if(!::productList.isInitialized) {
            productList = productsListRepository.fetchProducts()
        }
        return productList
    }
}