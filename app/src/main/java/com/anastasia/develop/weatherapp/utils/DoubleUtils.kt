package com.anastasia.develop.weatherapp.utils

fun Double.toCelsius():String {
    return this.toInt().toString() + "°"
}