/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.businesslogic.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.relsellglobal.moviesretrofitdemo.MyApplication
import com.relsellglobal.moviesretrofitdemo.R
import com.relsellglobal.moviesretrofitdemo.repository.ProductsListRepository
import com.relsellglobal.moviesretrofitdemo.viewmodels.ProductViewModelFactory
import com.relsellglobal.moviesretrofitdemo.viewmodels.ProductsListFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    lateinit var productsListFragmentViewModel: ProductsListFragmentViewModel

    @Inject
    lateinit var productsViewModelFactory: ProductViewModelFactory

    @Inject
    lateinit var productsListRepository: ProductsListRepository




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        (application as MyApplication).applicationComponent.inject(this)
//
//        productsListFragmentViewModel = ViewModelProvider(this,productsViewModelFactory).get(
//            ProductsListFragmentViewModel::class.java)





//        CoroutineScope(Dispatchers.Main).launch {
//            productsListFragmentViewModel.getProducts().observe(this@MainActivity, {
//            if (it != null && !it.isEmpty()) {
////                movieList.addAll(it)
////                adapter?.notifyDataSetChanged()
//                println()
//            }
//        })
//        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.rootLayout,ProductListFragment())
            .commit()



    }
}
