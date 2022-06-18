package com.relsellglobal.moviesretrofitdemo.di

import com.relsellglobal.moviesretrofitdemo.MyApplication
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,NetworkModule::class,ProductListModule::class])
interface ApplicationComponent {
    fun inject(app : MyApplication)
}