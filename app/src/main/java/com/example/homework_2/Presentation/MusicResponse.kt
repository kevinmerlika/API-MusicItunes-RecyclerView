package com.example.homework_2.Presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MusicResponse(

    val resultCount: Int,
    val results: List<results>
    ): Parcelable

@Parcelize
data class results (
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String?,
    val trackPrice: String?,
    ): Parcelable