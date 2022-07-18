package com.anastasia.develop.weatherapp.data.model

import com.google.gson.annotations.SerializedName


data class TodayWeather(
    @SerializedName("coord")
    var coordinates: Coordinates? = Coordinates(),

    @SerializedName("weather")
    var weather: ArrayList<Weather> = arrayListOf(),

    @SerializedName("base")
    var base: String? = null,

    @SerializedName("main")
    var main: Main? = Main(),

    @SerializedName("visibility")
    var visibility: Int? = null,

    @SerializedName("wind")
    var wind: Wind? = Wind(),

    @SerializedName("clouds")
    var clouds: Clouds? = Clouds(),

    @SerializedName("dt")
    var dateTime: Long,

    @SerializedName("sys")
    var systemInfo: SystemInfo? = SystemInfo(),

    @SerializedName("timezone")
    var timezone: Int? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("cod")
    var cod: Int? = null

)