package com.example.youtube_clone.pager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.youtube_clone.models2.YoutubeApiData
import com.example.youtube_clone.pager.UserDataSource
import com.example.youtube_clone.retrofit.RetrofitClient
import com.example.youtube_clone.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class UserViewModel : ViewModel() {

    private val liveData = MutableLiveData<Resource<YoutubeApiData>>()

    fun getWord(word:String): LiveData<Resource<YoutubeApiData>> {
        val apiService1 = RetrofitClient.apiService()

        viewModelScope.launch {
            liveData.postValue(Resource.loading(null))

            try {
                coroutineScope {

                    val async1 = async { apiService1.getData("snippet",word, "video","AIzaSyBwqkWWk4o9gfMggm1Kz8sWfnuPZySMGrg",200) }

                    val await1 = async1.await()

                    liveData.postValue(Resource.success(await1))

                }
            }catch (e: Exception){
                liveData.postValue(Resource.error(e.message ?: "Error",null))
            }



        }
        return liveData
    }



}