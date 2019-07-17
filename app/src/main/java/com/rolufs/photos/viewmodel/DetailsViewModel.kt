package com.rolufs.photos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.rolufs.photos.model.response.Photo
import com.rolufs.photos.model.response.PhotoAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {
    private var mutablePhoto: MutableLiveData<Photo> = MutableLiveData()
    private var photo: Photo? = null

    fun fetchPhoto(id: Int): MutableLiveData<Photo> {

        val photoAPI = PhotoAPI()

        GlobalScope.launch(Dispatchers.Main) {
            val yelpApiService = PhotoAPI()
            photo = yelpApiService.getPhoto(id).await()
            mutablePhoto.value = photo
        }

        return mutablePhoto
    }
}
