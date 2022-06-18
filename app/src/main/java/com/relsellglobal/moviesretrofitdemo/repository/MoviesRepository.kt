/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository

import androidx.lifecycle.MutableLiveData
import com.relsellglobal.moviesretrofitdemo.businesslogic.pojo.Product
import com.relsellglobal.moviesretrofitdemo.repository.network.ProductsApiService
import com.relsellglobal.moviesretrofitdemo.utils.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository private constructor() {
    private  var BaseUrl = AppConstants.Http.baseUrl

    private object HOLDER {
        val INSTANCE = MoviesRepository()
    }

    companion object {
        val instance: MoviesRepository by lazy { HOLDER.INSTANCE }
    }

    fun fetchProducts(): MutableLiveData<List<Product>> {

        val data = MutableLiveData<List<Product>>()

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ProductsApiService::class.java)
        val call = service.getProductsList()

        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.code() == 200) {
                    val movieResponse = response.body()!!
                    data.value = movieResponse
//                    for( movie in movieResponse.moviesArr){
//                        Log.v("MoviesRepository", movie.name)
//                    }


                }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                println(t)
            }
        })



        return data
    }


}