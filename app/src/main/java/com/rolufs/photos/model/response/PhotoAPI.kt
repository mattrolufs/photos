package com.rolufs.photos.model.response

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

val url = "https://jsonplaceholder.typicode.com/"

interface PhotoAPI {

    @GET ("photos")
    fun getPhotos() :Deferred<List<Photo>>

    @GET("photos/{photo}")
    fun getPhoto(@Path("photo") photo: Int) : Deferred<Photo>

    companion object {
        operator fun invoke(): PhotoAPI {

            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoAPI::class.java)
        }
    }
}
