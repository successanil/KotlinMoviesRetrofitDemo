/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository

import androidx.lifecycle.MutableLiveData
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Movie
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.MoviesResponse
import com.relsellglobal.moviesretrofitdemo.repository.moviesapi.MoviesService
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

    fun fetchMoviesData(year : Int): MutableLiveData<List<Movie>> {

        val data = MutableLiveData<List<Movie>>()

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MoviesService::class.java)
        val call = service.getMoviesList(""+year)

        call.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.code() == 200) {
                    val movieResponse = response.body()!!
                    data.value = movieResponse.moviesArr
//                    for( movie in movieResponse.moviesArr){
//                        Log.v("MoviesRepository", movie.name)
//                    }


                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                println(t)
            }
        })



        return data
    }


}