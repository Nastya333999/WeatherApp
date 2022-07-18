package com.anastasia.develop.weatherapp.data.model

import com.google.gson.annotations.SerializedName


data class CurrentForecastWeather(

    @SerializedName("lat")
    var latitude: Double? = null,

    @SerializedName("lon")
    var longitude: Double? = null,

    @SerializedName("timezone")
    var timezone: String? = null,

    @SerializedName("timezone_offset")
    var timezoneOffset: Int? = null,

    @SerializedName("current")
    var currentWeather: Current,

    @SerializedName("hourly")
    var hourlyWeather: ArrayList<Hourly> = arrayListOf(),

    @SerializedName("daily")
    var dailyWeather: ArrayList<Daily> = arrayListOf()

)