package com.relsellglobal.moviesretrofitdemo.businesslogic.models

import com.google.gson.annotations.SerializedName

data class ProductRating (
    @SerializedName("rate")
    var rate: Float = 0.0f,
    @SerializedName("count")
    var count: Int = 0,
        ) {
}