package com.example.youtube_clone.repository

import com.example.youtube_clone.retrofit.RetrofitService


class YoutubeRepository(val apiService: RetrofitService) {

    suspend fun getData() = apiService.getData()

}