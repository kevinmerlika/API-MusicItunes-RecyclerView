package com.example.homework_2.Remote

import android.util.Log
import com.example.homework_2.Presentation.MusicResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
// https://itunes.apple.com/search?term=rock&amp%3Bmedia=music&amp%3Bentity=song&amp%3Blimit=50 .
interface Api {
    @GET("search")
    fun getMusicByGenre(
        @Query("term") MusicGenre: String,
    ) : Call<MusicResponse>

    companion object{
        fun initretrofit(): Api{
            return Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }
}