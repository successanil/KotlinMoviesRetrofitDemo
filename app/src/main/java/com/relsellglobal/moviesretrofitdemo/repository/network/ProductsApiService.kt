/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository.network

import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductsApiService {
    @GET("products")
    fun getProductsList() : Call<List<Product>>
}



