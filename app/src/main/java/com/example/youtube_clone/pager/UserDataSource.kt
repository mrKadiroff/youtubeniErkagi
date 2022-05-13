package com.example.youtube_clone.pager

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.youtube_clone.models2.Item
import com.example.youtube_clone.models2.YoutubeApiData
import com.example.youtube_clone.retrofit.RetrofitService
import java.lang.Exception

class UserDataSource (val apiService: RetrofitService, val photo:String): PagingSource<Int, Item>() {
    private val TAG = "UserDataSource"
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        try {
            var pahto:String
            Log.d(TAG, "load: $photo")
            val nextPageNumber = params.key ?: 1
            val usersData = apiService.getData("snippet",photo, "video","AIzaSyBwqkWWk4o9gfMggm1Kz8sWfnuPZySMGrg",200)
            return LoadResult.Page(usersData.items,null,nextPageNumber + 1)

        }catch (e: Exception){
            return LoadResult.Error(e)
        }




    }
}