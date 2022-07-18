package com.anastasia.develop.weatherapp.data.model

import com.google.gson.annotations.SerializedName


data class Daily(

    @SerializedName("dt")
    var dt: Long? = null,

    @SerializedName("sunrise")
    var dailySunrise: Int? = null,

    @SerializedName("sunset")
    var dailySunset: Int? = null,

    @SerializedName("moonrise")
    var dailyMoonrise: Int? = null,

    @SerializedName("moonset")
    var dailyMoonset: Int? = null,

    @SerializedName("moon_phase")
    var dailyMoonPhase: Double? = null,

    @SerializedName("temp")
    var dailyTemp: Temp? = Temp(),

    @SerializedName("feels_like")
    var dailyFeelsLike: FeelsLike? = FeelsLike(),

    @SerializedName("pressure")
    var pressure: Int? = null,

    @SerializedName("humidity")
    var humidity: Int? = null,

    @SerializedName("dew_point")
    var dewPoint: Double? = null,

    @SerializedName("wind_speed")
    var windSpeed: Double? = null,

    @SerializedName("wind_deg")
    var windDeg: Int? = null,

    @SerializedName("wind_gust")
    var windGust: Double? = null,

    @SerializedName("weather")
    var dailyWeather: ArrayList<Weather> = arrayListOf(),

    @SerializedName("clouds")
    var dailyClouds: Int? = null,

    @SerializedName("pop")
    var pop: Double? = null,

    @SerializedName("uvi")
    var uvi: Double? = null

)