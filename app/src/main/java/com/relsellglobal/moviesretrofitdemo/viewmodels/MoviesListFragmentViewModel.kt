/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Movie
import com.relsellglobal.moviesretrofitdemo.repository.MoviesRepository

class MoviesListFragmentViewModel : ViewModel() {
    private lateinit var moviesList : MutableLiveData<List<Movie>>

    fun fetchMoviesForYear(year : Int) : LiveData<List<Movie>> {
        if(!::moviesList.isInitialized){
            moviesList = MutableLiveData()
            moviesList = loadMovies(year)
        }
        return moviesList
    }

    private fun loadMovies(year : Int): MutableLiveData<List<Movie>> {
        return MoviesRepository.instance.fetchMoviesData(year)
    }
}