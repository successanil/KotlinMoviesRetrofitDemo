/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository.network

import com.relsellglobal.moviesretrofitdemo.businesslogic.models.Product
import retrofit2.http.GET

interface ProductsApiService {
    @GET("products")
    suspend fun getProductsList() : List<Product>
}



