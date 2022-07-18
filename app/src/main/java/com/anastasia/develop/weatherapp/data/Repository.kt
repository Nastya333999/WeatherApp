package com.anastasia.develop.weatherapp.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.anastasia.develop.weatherapp.data.model.City
import com.anastasia.develop.weatherapp.data.model.CurrentForecastWeather
import com.anastasia.develop.weatherapp.data.model.TodayWeather

class Repository {
    private val cities = listOf<City>(
        City("Киев", 50.4546600, 30.5238000, 1),
        City("Харьков", 49.9808100, 36.2527200, 2),
        City("Донецк", 48.0230000, 37.8022400, 3),
        City("Одесса", 46.4774700, 30.7326200, 4),
        City("Луганск", 48.5670500, 39.3170600, 5),
        City("Львов", 49.8382600, 24.0232400, 6),
        City("Луцк", 50.7593200, 25.3424400, 7),
        City("Симферополь", 44.9571900, 34.1107900, 8),
    )

    fun getCities() = cities


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val serverApi = retrofit.create(ServerApi::class.java)

    suspend fun getWeatherByCityId(id: Int): Response<TodayWeather> {
        val city = cities.first { it.id == id }
        return serverApi.getWeather(city.lat, city.long)

    }

    suspend fun getCurrentForecastWeather(id: Int): Response<CurrentForecastWeather> {
        val city = cities.first { it.id == id }
        return serverApi.getDailyForecast(city.lat, city.long)
    }
}