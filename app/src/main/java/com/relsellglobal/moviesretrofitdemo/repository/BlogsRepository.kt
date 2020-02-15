/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository

import androidx.lifecycle.MutableLiveData
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Blog
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.BlogsResponse
import com.relsellglobal.moviesretrofitdemo.repository.moviesapi.BlogsService
import com.relsellglobal.moviesretrofitdemo.utils.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BlogsRepository private constructor() {
    private  var BaseUrl = AppConstants.Http.baseUrl

    private object HOLDER {
        val INSTANCE = BlogsRepository()
    }

    companion object {
        val INSTANCE: BlogsRepository by lazy { HOLDER.INSTANCE }
    }

    fun fetchMoviesData(year : Int): MutableLiveData<List<Blog>> {

        val data = MutableLiveData<List<Blog>>()

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(BlogsService::class.java)
        val call = service.getMoviesList(""+year)

        call.enqueue(object : Callback<BlogsResponse> {
            override fun onResponse(call: Call<BlogsResponse>, response: Response<BlogsResponse>) {
                if (response.code() == 200) {
                    val movieResponse = response.body()!!
                    data.value = movieResponse.moviesArr
//                    for( movie in movieResponse.moviesArr){
//                        Log.v("MoviesRepository", movie.name)
//                    }


                }
            }
            override fun onFailure(call: Call<BlogsResponse>, t: Throwable) {

            }
        })



        return data
    }


}