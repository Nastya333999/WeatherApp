package com.anastasia.develop.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lon")
    var longitude: Double? = null,

    @SerializedName("lat")
    var latitude: Double? = null
)