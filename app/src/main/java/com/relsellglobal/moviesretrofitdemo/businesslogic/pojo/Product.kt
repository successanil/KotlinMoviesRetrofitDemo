/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.businesslogic.pojo

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("title")
    var title: String = "",

    @SerializedName("price")
    var price: Float = 0.0f,

    @SerializedName("description")
    var description: String = "",

    @SerializedName("category")
    var category: String = "",

    @SerializedName("image")
    var image: String = "",

    @SerializedName("rating")
    var rating: ProductRating? = null
) {

}