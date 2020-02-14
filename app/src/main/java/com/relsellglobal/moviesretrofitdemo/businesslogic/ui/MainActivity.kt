/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.businesslogic.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.relsellglobal.moviesretrofitdemo.R

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.rootLayout,MoviesListFragment())
            .commit()



    }
}
