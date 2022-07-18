package com.anastasia.develop.weatherapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anastasia.develop.weatherapp.R


class MainFragment : Fragment() {
    private val recyclerView by lazy { view?.findViewById<RecyclerView>(R.id.recyclerView) }
    private var adapter:CitiesAdapter? = null
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(context)

        recyclerView?.layoutManager = layoutManager
        adapter = CitiesAdapter()
        recyclerView?.adapter = adapter
    }

    private fun initObservers() {
        viewModel.cities.observe(viewLifecycleOwner) {
            adapter?.setData(it)
            adapter?.notifyDataSetChanged()
        }
    }


}