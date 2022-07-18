package com.anastasia.develop.weatherapp.ui.city

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.anastasia.develop.weatherapp.data.Repository
import com.anastasia.develop.weatherapp.data.model.CurrentForecastWeather
import java.lang.Exception

class CityWeatherViewModel : ViewModel() {

    val weather = MutableLiveData<CurrentForecastWeather>()
    val errorMassage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    private val repository = Repository()

    fun getWeather(cityId: Int?) {
        if (cityId == null)
            return

        viewModelScope.launch {
            loading.postValue(true)
            try {
                val weather = repository.getCurrentForecastWeather(cityId)
                if (weather.isSuccessful) {
                    this@CityWeatherViewModel.weather.postValue(weather.body())
                } else {
                    errorMassage.postValue(weather.message())
                }
            } catch (e: Exception) {
                Log.e("eee", e.stackTraceToString())
            }
            loading.postValue(false)
        }
    }
}


















