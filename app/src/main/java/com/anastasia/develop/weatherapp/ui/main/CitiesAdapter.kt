package com.anastasia.develop.weatherapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.anastasia.develop.weatherapp.R
import com.anastasia.develop.weatherapp.data.model.City

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    private val items = mutableListOf<City>()

    fun setData(list: List<City>) {
        items.clear()
        items.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        private lateinit var dataItem: City

        init {
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("cityId", dataItem.id)
                val cityId = dataItem.id
                itemView.findNavController().navigate(R.id.cities_fragment, bundle)
            }
        }

        fun setData(item: City) {
            dataItem = item
            itemTitle.text = dataItem.name
        }
    }


}