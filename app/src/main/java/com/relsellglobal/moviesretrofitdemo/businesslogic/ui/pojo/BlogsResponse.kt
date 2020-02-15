/*
 * Copyright (c) 2020. Relsell Global
 */


package com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo

import com.google.gson.annotations.SerializedName


class BlogsResponse {
    @SerializedName("moviesArr")
    var moviesArr = ArrayList<Blog>()
}