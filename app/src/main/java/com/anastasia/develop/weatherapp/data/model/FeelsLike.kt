package com.anastasia.develop.weatherapp.data.model

import com.google.gson.annotations.SerializedName


data class FeelsLike (

  @SerializedName("day"   ) var day   : Double? = null,
  @SerializedName("night" ) var night : Double? = null,
  @SerializedName("eve"   ) var eve   : Double? = null,
  @SerializedName("morn"  ) var morn  : Double? = null

)