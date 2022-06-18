/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository

import androidx.lifecycle.MutableLiveData
import com.relsellglobal.moviesretrofitdemo.businesslogic.models.Product
import com.relsellglobal.moviesretrofitdemo.repository.network.ProductsApiService
import com.relsellglobal.moviesretrofitdemo.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ProductsListRepository @Inject constructor(private val productsApiService: ProductsApiService) {

    suspend fun fetchProducts(): MutableLiveData<List<Product>> {

        val data = MutableLiveData<List<Product>>()
        data.value = productsApiService.getProductsList()

        return data
    }


}