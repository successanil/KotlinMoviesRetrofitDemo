package com.relsellglobal.moviesretrofitdemo

import android.app.Application
import com.relsellglobal.moviesretrofitdemo.di.ApplicationComponent
import com.relsellglobal.moviesretrofitdemo.di.DaggerApplicationComponent

class MyApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}