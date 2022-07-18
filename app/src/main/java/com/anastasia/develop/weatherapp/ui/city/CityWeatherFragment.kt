package com.anastasia.develop.weatherapp.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anastasia.develop.weatherapp.R
import com.anastasia.develop.weatherapp.utils.IconUtil
import com.anastasia.develop.weatherapp.utils.toCelsius
import java.text.SimpleDateFormat
import java.util.*


class CityWeatherFragment : Fragment() {
    lateinit var viewModel: CityWeatherViewModel
    lateinit var txtCityName: TextView
    lateinit var txtDate: TextView
    lateinit var imgWeather: ImageView
    lateinit var txtCurrentTemp: TextView
    lateinit var txtClouds: TextView
    lateinit var txtDailyTemp: TextView
    lateinit var txtFeelingTemp: TextView
    lateinit var prgLoading: ProgressBar
    val dayFormator = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    private val recyclerViewCurrent by lazy { view?.findViewById<RecyclerView>(R.id.rv_current) }
    private val currentDayWeatherAdapter = CurrentDayWeatherAdapter()

    private val recyclerViewWeekWeather by lazy { view?.findViewById<RecyclerView>(R.id.rv_days_weather)  }
    private val weekWeatherAdapter = WeekWeatherAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CityWeatherViewModel::class.java)
        val cityId = arguments?.getInt("cityId")
        viewModel.getWeather(cityId)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtCityName = view.findViewById(R.id.txt_city_name)
        txtDate = view.findViewById(R.id.txt_date)
        imgWeather = view.findViewById(R.id.img_weather)
        txtCurrentTemp = view.findViewById(R.id.txt_current_temp)
        txtClouds = view.findViewById(R.id.txt_clouds)
        txtDailyTemp = view.findViewById(R.id.txt_daily_temp)
        txtFeelingTemp = view.findViewById(R.id.txt_feeling_temp)
        prgLoading = view.findViewById(R.id.prg_loading)

        initObservers()
        initRecyclerView()

    }

    private fun initObservers() {
        viewModel.weather.observe(viewLifecycleOwner) {
//            txtCityName.text = it.name
            txtDate.text = dayFormator.format(Date(it.currentWeather.dt * 1000))
            imgWeather.setImageResource(IconUtil.getIconById(it.currentWeather.weather.first().icon.toString()))
            txtCurrentTemp.text = it.currentWeather.temp?.toCelsius()
            txtClouds.text = it.currentWeather.clouds.toString()
            txtDailyTemp.text = it.currentWeather.temp?.toCelsius()
            txtFeelingTemp.text = it.currentWeather.feelsLike.toString()

            currentDayWeatherAdapter.setData(it.hourlyWeather)
            currentDayWeatherAdapter.notifyDataSetChanged()
            weekWeatherAdapter.setData(it.dailyWeather)
            weekWeatherAdapter.notifyDataSetChanged()

        }
        viewModel.errorMassage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }


        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) {
                prgLoading.visibility = View.VISIBLE
            } else {
                prgLoading.visibility = View.INVISIBLE
            }
        }
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerViewCurrent?.layoutManager = layoutManager
        recyclerViewCurrent?.adapter = currentDayWeatherAdapter

        val verticalLayoutManager = LinearLayoutManager(context)
        recyclerViewWeekWeather?.layoutManager = verticalLayoutManager
        recyclerViewWeekWeather?.adapter = weekWeatherAdapter
        recyclerViewWeekWeather?.isNestedScrollingEnabled = false
    }


}