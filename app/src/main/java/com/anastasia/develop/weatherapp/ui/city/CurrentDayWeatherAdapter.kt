package com.anastasia.develop.weatherapp.ui.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anastasia.develop.weatherapp.R
import com.anastasia.develop.weatherapp.data.model.Hourly
import com.anastasia.develop.weatherapp.utils.IconUtil
import com.anastasia.develop.weatherapp.utils.toCelsius
import java.text.SimpleDateFormat
import java.util.*

class CurrentDayWeatherAdapter : RecyclerView.Adapter<CurrentDayWeatherAdapter.ViewHolder>() {
    private val items = mutableListOf<Hourly>()
    val dayFormatter = SimpleDateFormat("hh:mm", Locale.getDefault())

    fun setData(list: List<Hourly>) {
        items.clear()
        items.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_current_weather_day, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val curentTime = itemView.findViewById<TextView>(R.id.txt_curent_time)
        val imgCurent = itemView.findViewById<ImageView>(R.id.img_curent)
        val txtTempCurent = itemView.findViewById<TextView>(R.id.txt_temp_curent)
        val txtCurrentPop = itemView.findViewById<TextView>(R.id.txt_current_pop)

        private lateinit var dataHourly: Hourly

        fun setData(item: Hourly) {
            dataHourly = item
            curentTime.text = dayFormatter.format(Date(dataHourly.dt!! * 1000))
            imgCurent.setImageResource(IconUtil.getIconById(dataHourly.weather.first().icon.toString()))
            txtTempCurent.text = dataHourly.temp?.toCelsius()
            txtCurrentPop.text = dataHourly.pop.toString()
        }
    }
}