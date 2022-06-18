/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.businesslogic.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.moviesretrofitdemo.MyApplication
import com.relsellglobal.moviesretrofitdemo.R
import com.relsellglobal.moviesretrofitdemo.businesslogic.models.Product
import com.relsellglobal.moviesretrofitdemo.viewmodels.ProductViewModelFactory
import com.relsellglobal.moviesretrofitdemo.viewmodels.ProductsListFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ProductListFragment.OnListFragmentInteractionListener] interface.
 */
class ProductListFragment : Fragment() {

    lateinit var productsListFragmentViewModel: ProductsListFragmentViewModel

    @Inject
    lateinit var productsViewModelFactory: ProductViewModelFactory




    // TODO: Customize parameters
    private var columnCount = 1


    var moviesListRV : RecyclerView ?= null
    var adapter : ProductItemRecyclerViewAdapter ?= null

    var movieList = ArrayList<Product>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_item_list, container, false)

        moviesListRV = view.findViewById(R.id.list)

        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        adapter = ProductItemRecyclerViewAdapter(movieList)
        moviesListRV?.layoutManager = LinearLayoutManager(activity)
        moviesListRV?.adapter = adapter

//        productsListFragmentViewModel = ViewModelProvider(requireActivity(),productsViewModelFactory).get(ProductsListFragmentViewModel::class.java)
//
//        productsListFragmentViewModel.productsLiveData.observe(requireActivity(), {
//                if (it != null && !it.isEmpty()) {
//                    movieList.addAll(it)
//                    adapter?.notifyDataSetChanged()
//                }
//            })




    }

//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: DummyItem?)
//    }

}
