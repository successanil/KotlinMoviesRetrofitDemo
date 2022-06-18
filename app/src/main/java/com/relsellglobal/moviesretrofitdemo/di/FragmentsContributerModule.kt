package com.relsellglobal.moviesretrofitdemo.di

import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.ProductListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsContributerModule {

    @ContributesAndroidInjector
    abstract fun contributeProductListFragment () : ProductListFragment
}