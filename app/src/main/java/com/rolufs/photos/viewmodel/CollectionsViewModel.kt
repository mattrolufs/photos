package com.rolufs.photos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.rolufs.photos.model.response.Photo
import com.rolufs.photos.model.response.PhotoAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CollectionsViewModel : ViewModel() {

    private var mutablePhotos : MutableLiveData<List<Photo>> = MutableLiveData()
    private var photos : List<Photo>? = null



    fun fetchPhotos() : MutableLiveData<List<Photo>> {

        val photoAPI = PhotoAPI()

        GlobalScope.launch(Dispatchers.Main){
            val yelpApiService = PhotoAPI()
            photos = yelpApiService.getPhotos().await()
            mutablePhotos.value = photos
        }

        return mutablePhotos
    }

}
