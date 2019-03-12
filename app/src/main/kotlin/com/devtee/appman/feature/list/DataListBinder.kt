package com.devtee.appman.feature.list

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.devtee.appman.common.Binder
import com.devtee.appman.common.viewModel
import com.devtee.appman.databinding.ActivityDataListBinding
import com.devtee.appman.feature.list.di.DataListComponent

class DataListBinder(activity: AppCompatActivity,
                     binding: ActivityDataListBinding,
                     component: DataListComponent) : Binder {

    private val viewModel = activity.viewModel { component.getDataListViewModel() }
    private val view = DataListViewImpl(binding, viewModel)

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.data.observe(owner, Observer { view.setItems(it) })
    }
}