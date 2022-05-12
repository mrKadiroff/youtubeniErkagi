package com.example.youtube_clone.retrofit

import com.example.youtube_clone.models2.YoutubeApiData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    fun getData(@Query("part") part:String,
                        @Query("q") q:String,
                        @Query("type") type:String,
                        @Query("key") key: String,
                        @Query("maxResults") maxResults:Int
    ): Call<YoutubeApiData>


}