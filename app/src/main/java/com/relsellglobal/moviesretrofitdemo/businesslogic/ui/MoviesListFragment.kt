/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.businesslogic.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.moviesretrofitdemo.R
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Movie
import com.relsellglobal.moviesretrofitdemo.viewmodels.MoviesListFragmentViewModel

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [MoviesListFragment.OnListFragmentInteractionListener] interface.
 */
class MoviesListFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1


    var moviesListRV : RecyclerView ?= null
    var adapter : MovieItemRecyclerViewAdapter ?= null

    var movieList = ArrayList<Movie>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_item_list, container, false)

        moviesListRV = view.findViewById(R.id.list)

        return view
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = MovieItemRecyclerViewAdapter(movieList)
        moviesListRV?.layoutManager = LinearLayoutManager(activity)
        moviesListRV?.adapter = adapter

        val model = ViewModelProviders.of(this).get(MoviesListFragmentViewModel::class.java)

        model.fetchMoviesForYear(2011).observe(this, Observer {
            if (it != null && !it.isEmpty()) {
                movieList.addAll(it)
                adapter?.notifyDataSetChanged()
            }
        })

    }

//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: DummyItem?)
//    }

}
