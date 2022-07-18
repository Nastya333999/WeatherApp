package com.anastasia.develop.weatherapp.data.model

import com.google.gson.annotations.SerializedName


data class Weather(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("main")
    var main: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("icon")
    var icon: String? = null

)