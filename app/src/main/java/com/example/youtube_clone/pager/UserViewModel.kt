package com.example.youtube_clone.pager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.youtube_clone.pager.UserDataSource
import com.example.youtube_clone.retrofit.RetrofitClient

class UserViewModel : ViewModel() {

   var word:String = ""
    val liveData = Pager(PagingConfig(pageSize = 2)){

            UserDataSource(RetrofitClient.apiService,word)
        }.liveData.cachedIn(viewModelScope)



}