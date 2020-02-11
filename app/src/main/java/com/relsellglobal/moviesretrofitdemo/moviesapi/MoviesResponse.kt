/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.moviesapi

import com.google.gson.annotations.SerializedName

class Movie{
    @SerializedName("name")
    var name = ""
    @SerializedName("year")
    var year = ""
}


class MoviesResponse {
    @SerializedName("moviesArr")
    var moviesArr = ArrayList<Movie>()
}