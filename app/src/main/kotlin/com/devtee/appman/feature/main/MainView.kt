package com.devtee.appman.feature.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.devtee.appman.databinding.ActivityMainBinding

interface MainView {
    fun setItems(items: List<MainItem>?)
}

class MainViewImpl(binding: ActivityMainBinding, viewModel: MainViewModel) : MainView {

    private val listAdapter = MainListAdapter(viewModel)

    init {
        with(binding.recyclerViewList) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

    override fun setItems(items: List<MainItem>?) {
        listAdapter.items = items ?: emptyList()
    }
}