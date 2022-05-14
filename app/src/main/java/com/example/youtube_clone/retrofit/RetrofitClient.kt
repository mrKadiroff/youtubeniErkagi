package com.example.youtube_clone.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://www.googleapis.com/youtube/v3/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun apiService() :RetrofitService{
        return getRetrofit().create(RetrofitService::class.java)
    }

}