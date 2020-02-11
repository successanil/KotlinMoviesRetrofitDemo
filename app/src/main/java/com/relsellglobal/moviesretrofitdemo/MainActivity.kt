package com.relsellglobal.moviesretrofitdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.relsellglobal.moviesretrofitdemo.moviesapi.MoviesResponse
import com.relsellglobal.moviesretrofitdemo.moviesapi.MoviesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var BaseUrl = "https://www.relsellglobal.in/tutorial_blogs/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MoviesService::class.java)
        val call = service.getMoviesList("2000")

        call.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.code() == 200) {
                    val movieResponse = response.body()!!
                    for( movie in movieResponse.moviesArr){
                        Log.v("MainActivity", movie.name)
                    }


                }
            }
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {

            }
        })


    }
}
