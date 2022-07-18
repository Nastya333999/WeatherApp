package com.anastasia.develop.weatherapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.anastasia.develop.weatherapp.data.model.CurrentForecastWeather
import com.anastasia.develop.weatherapp.data.model.TodayWeather


interface ServerApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = "93f16bfbb2cfd4e7fe6fb43c939e6b18",
        @Query("units") units: String = "metric"
    ): Response<TodayWeather>

    @GET("onecall")
    suspend fun getDailyForecast(
        @Query("lat") latitude: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = "93f16bfbb2cfd4e7fe6fb43c939e6b18",
        @Query("units") units: String = "metric"
    ): Response<CurrentForecastWeather>
}