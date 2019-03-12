package com.devtee.appman.feature.list

import androidx.recyclerview.widget.LinearLayoutManager
import com.devtee.appman.databinding.ActivityDataListBinding

interface DataListView {
    fun setItems(items: List<DataListItem>?)
}

class DataListViewImpl(binding: ActivityDataListBinding, viewModel: DataListViewModel) : DataListView {

    private val listAdapter = DataListAdapter(viewModel)

    init {
        with(binding.recyclerViewList) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

    override fun setItems(items: List<DataListItem>?) {
        listAdapter.items = items ?: emptyList()
    }
}