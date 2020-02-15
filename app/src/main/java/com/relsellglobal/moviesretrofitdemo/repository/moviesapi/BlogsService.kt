/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.repository.moviesapi

import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.BlogsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogsService {
    @GET("movies.php?")
    fun getMoviesList(@Query("year") year : String) : Call<BlogsResponse>
}



