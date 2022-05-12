package com.example.youtube_clone.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtube_clone.models2.YoutubeApiData
import com.example.youtube_clone.repository.YoutubeRepository
import com.example.youtube_clone.retrofit.RetrofitClient
import com.example.youtube_clone.utils.NetworkHelper
import com.example.youtube_clone.utils.Resource
import kotlinx.coroutines.launch

class YoutubeViewModel : ViewModel() {

    private val youtubeRepository = YoutubeRepository(RetrofitClient.apiService)
    private val liveData = MutableLiveData<Resource<YoutubeApiData>>()

    fun getYoutubeData(context: Context): LiveData<Resource<YoutubeApiData>>{
        val networkHelper = NetworkHelper(context)
        if (networkHelper.isNetworkConnected()){
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val responce = youtubeRepository.getData()
                if (responce.isSuccessful){
                    liveData.postValue(Resource.success(responce.body()))
                }else {
                    liveData.postValue(Resource.error(responce.errorBody()?.string().toString(),null))
                }
            }
        }else{
           liveData.postValue(Resource.error("Internet not connected",null))
        }
        return liveData



    }

}