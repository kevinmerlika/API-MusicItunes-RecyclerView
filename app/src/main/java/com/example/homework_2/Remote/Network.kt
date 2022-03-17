package com.example.homework_2

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.homework_2.Presentation.MusicResponse
import com.example.homework_2.Presentation.results
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

private const val TAG = "Network"
fun FragmentActivity.isDeviceConnected(): Boolean{
    val connectivitymanager = getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager

    val networkInfo: NetworkInfo? = connectivitymanager.activeNetworkInfo
    return networkInfo?.isConnected ?: false
}


