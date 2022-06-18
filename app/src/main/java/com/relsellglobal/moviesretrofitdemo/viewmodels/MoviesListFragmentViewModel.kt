/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.relsellglobal.moviesretrofitdemo.businesslogic.pojo.Product
import com.relsellglobal.moviesretrofitdemo.repository.MoviesRepository
import kotlinx.coroutines.launch

class MoviesListFragmentViewModel : ViewModel() {
    private lateinit var moviesList : MutableLiveData<List<Product>>

    suspend fun fetchProducts() : LiveData<List<Product>> {
        if(!::moviesList.isInitialized){
            //moviesList = MutableLiveData()
            moviesList = loadProducts()
        }
        return moviesList
    }

    private suspend fun loadProducts(): MutableLiveData<List<Product>> {
        var data : MutableLiveData<List<Product>>
        data = MoviesRepository.instance.fetchProducts()
        return data
    }
}