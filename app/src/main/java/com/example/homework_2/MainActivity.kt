package com.example.homework_2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.homework_2.Presentation.MusicResponse
import com.example.homework_2.Remote.Api
import com.example.homework_2.View.MusicListFragment
import com.example.homework_2.View.searchMusicFragment
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.concurrent.thread


private val TAG: String = "Error"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(isDeviceConnected()){
            supportFragmentManager.beginTransaction().replace(R.id.container_search, searchMusicFragment())
                .commit()

            executeRetrofit("classic")
        }
        else
            showError()
    }

    fun executeRetrofit(MusicGenre: String) {
        Api.initretrofit().getMusicByGenre(MusicGenre)
            .enqueue(object: Callback<MusicResponse>{
                override fun onResponse(
                    call: Call<MusicResponse>,
                    response: Response<MusicResponse>
                ) {
                    if(response.isSuccessful){
                        inflateDisplayFragment(response.body())
                    }
                    else
                        showError()
                }

                override fun onFailure(call: Call<MusicResponse>, t: Throwable) {
                    showError()
                }

            })
    }

    private fun inflateDisplayFragment(dataset: MusicResponse?){
        dataset?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_display, MusicListFragment.newInstance(it))
                .commit()
        }
    }

    private fun showError() {
        Snackbar.make(findViewById(R.id.container_display),
            "No Network, try again",
            Snackbar.LENGTH_INDEFINITE)
            .setAction("Retry"){
                Log.d(TAG, "showError: RETRIED")

            }.show()
    }












}