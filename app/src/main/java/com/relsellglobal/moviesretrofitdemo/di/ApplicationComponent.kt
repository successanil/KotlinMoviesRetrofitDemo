package com.relsellglobal.moviesretrofitdemo.di

import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}