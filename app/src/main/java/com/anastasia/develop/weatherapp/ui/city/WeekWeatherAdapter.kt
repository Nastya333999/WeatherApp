package com.anastasia.develop.weatherapp.ui.city

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anastasia.develop.weatherapp.R
import com.anastasia.develop.weatherapp.data.model.Daily
import com.anastasia.develop.weatherapp.utils.IconUtil
import com.anastasia.develop.weatherapp.utils.toCelsius
import java.text.SimpleDateFormat
import java.util.*

class WeekWeatherAdapter : RecyclerView.Adapter<WeekWeatherAdapter.ViewHolder>() {
    private val items = mutableListOf<Daily>()

    val dayFormatter = SimpleDateFormat("EEEE", Locale.getDefault())

    fun setData(list: List<Daily>) {
        items.clear()
        items.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_weather, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount(): Int = items.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtDayName = itemView.findViewById<TextView>(R.id.txt_day_name)
        val txtPop = itemView.findViewById<TextView>(R.id.txt_pop)
        val txtTempDayNight = itemView.findViewById<TextView>(R.id.txt_temp_day_night)
        val imgWeatherDay = itemView.findViewById<ImageView>(R.id.img_weather_day)

        private lateinit var dataDaily: Daily

        fun setData(item: Daily) {
            dataDaily = item
            txtPop.text = dataDaily.pop.toString()
            txtTempDayNight.text = dataDaily.dailyTemp?.day?.toCelsius() + "/" + dataDaily.dailyTemp?.night?.toCelsius()
            imgWeatherDay.setImageResource(IconUtil.getIconById(dataDaily.dailyWeather.first().icon.toString()))
            Log.d("weather", dataDaily.dailyWeather.toString())
            txtDayName.text = dayFormatter.format(Date(dataDaily.dt!! * 1000))
        }

    }
}