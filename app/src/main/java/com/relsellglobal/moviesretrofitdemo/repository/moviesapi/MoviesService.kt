/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository.moviesapi

import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("movies.php?")
    fun getMoviesList(@Query("year") year : String) : Call<MoviesResponse>
}



