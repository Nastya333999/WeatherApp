package com.anastasia.develop.weatherapp.utils

import com.anastasia.develop.weatherapp.R

class IconUtil {
    companion object {
        fun getIconById(id: String): Int {
            return when (id) {
                "01d" -> R.drawable.ic_01d
                "02d" -> R.drawable.ic_02d
                "03d" -> R.drawable.ic_03d
                "04d" -> R.drawable.ic_04d
                "09d" -> R.drawable.ic_09d
                "10d" -> R.drawable.ic_10d
                "11d" -> R.drawable.ic_11d
                "13d" -> R.drawable.ic_13d
                "50d" -> R.drawable.ic_50d
                else -> R.drawable.ic_01d
            }

        }
    }
}