package com.example.youtube_clone.retrofit

import com.example.youtube_clone.models2.YoutubeApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    suspend fun getData(@Query("part") part:String = "snippet",
                        @Query("q") q:String = "eminem",
                        @Query("type") type:String = "video",
                        @Query("key") key: String = "AIzaSyBwqkWWk4o9gfMggm1Kz8sWfnuPZySMGrg",
                        @Query("maxResults") maxResults:Int = 20
    ): Response<YoutubeApiData>


}