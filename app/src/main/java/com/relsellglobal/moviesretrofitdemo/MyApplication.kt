package com.relsellglobal.moviesretrofitdemo

import android.app.Application
import com.relsellglobal.moviesretrofitdemo.di.ApplicationComponent
import com.relsellglobal.moviesretrofitdemo.di.DaggerApplicationComponent
import com.relsellglobal.moviesretrofitdemo.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .networkModule(NetworkModule())
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}