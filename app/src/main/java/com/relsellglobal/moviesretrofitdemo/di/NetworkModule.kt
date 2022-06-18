package com.relsellglobal.moviesretrofitdemo.di

import com.relsellglobal.moviesretrofitdemo.repository.network.ProductsApiService
import com.relsellglobal.moviesretrofitdemo.utils.AppConstants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.Http.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesProductApiService(retrofit: Retrofit) : ProductsApiService {
        return retrofit.create(ProductsApiService::class.java)
    }

}