package com.example.youtube_clone.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtube_clone.models2.YoutubeApiData

import com.example.youtube_clone.retrofit.RetrofitClient
import com.example.youtube_clone.utils.NetworkHelper
import com.example.youtube_clone.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class YoutubeViewModel : ViewModel() {

    private var liveData = MutableLiveData<YoutubeApiData>()
    private val TAG = "MainViewModel"

    fun getWeather(lait:Double,longit:Double): MutableLiveData<YoutubeApiData> {


//        RetrofitClient.apiService().getData("snippet","eminem", "video","AIzaSyBwqkWWk4o9gfMggm1Kz8sWfnuPZySMGrg",20).enqueue(object:
//        Callback<YoutubeApiData>{
//            override fun onResponse(
//                call: Call<YoutubeApiData>,
//                response: Response<YoutubeApiData>
//            ) {
//                if (response.isSuccessful){
//                    liveData.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<YoutubeApiData>, t: Throwable) {
//                Log.d(TAG, "onFailure: ${t.message}")
//            }
//
//        })

        return liveData
    }

}