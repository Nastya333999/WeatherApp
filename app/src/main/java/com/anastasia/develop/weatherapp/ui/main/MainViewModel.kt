package com.anastasia.develop.weatherapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anastasia.develop.weatherapp.data.Repository
import com.anastasia.develop.weatherapp.data.model.City

class MainViewModel : ViewModel() {
    private val repository = Repository()

    val cities = MutableLiveData<List<City>>()

    init {
        val titles = repository.getCities()

        cities.postValue(titles)
    }


}