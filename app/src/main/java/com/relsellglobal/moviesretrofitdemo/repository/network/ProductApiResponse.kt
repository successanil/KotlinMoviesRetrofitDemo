/*
 * Copyright (c) 2020. Relsell Global
 */


package com.relsellglobal.moviesretrofitdemo.repository.network

import com.google.gson.annotations.SerializedName
import com.relsellglobal.moviesretrofitdemo.businesslogic.pojo.Product


class ProductApiResponse {
    @SerializedName("moviesArr")
    var moviesArr = ArrayList<Product>()
}