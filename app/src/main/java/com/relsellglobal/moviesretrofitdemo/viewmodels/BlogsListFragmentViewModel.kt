/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Blog
import com.relsellglobal.moviesretrofitdemo.repository.BlogsRepository

class BlogsListFragmentViewModel : ViewModel() {
    private lateinit var moviesList : MutableLiveData<List<Blog>>

    fun fetchMoviesForYear(year : Int) : LiveData<List<Blog>> {
        if(!::moviesList.isInitialized){
            moviesList = MutableLiveData()
            moviesList = loadMovies(year)
        }
        return moviesList
    }

    private fun loadMovies(year : Int): MutableLiveData<List<Blog>> {
        return BlogsRepository.INSTANCE.fetchMoviesData(year)
    }
}