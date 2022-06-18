/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Product
import com.relsellglobal.moviesretrofitdemo.repository.MoviesRepository

class MoviesListFragmentViewModel : ViewModel() {
    private lateinit var moviesList : MutableLiveData<List<Product>>

    fun fetchProducts() : LiveData<List<Product>> {
        if(!::moviesList.isInitialized){
            //moviesList = MutableLiveData()
            moviesList = loadProducts()
        }
        return moviesList
    }

    private fun loadProducts(): MutableLiveData<List<Product>> {
        return MoviesRepository.instance.fetchProducts()
    }
}