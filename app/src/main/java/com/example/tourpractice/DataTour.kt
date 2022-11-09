package com.example.tourpractice

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataTour(
    val image_tour: Int,
    val tour_name: String,
    val tour_description: String
) : Parcelable
