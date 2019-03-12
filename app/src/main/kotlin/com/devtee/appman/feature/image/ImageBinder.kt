package com.devtee.appman.feature.image

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.devtee.appman.common.Binder
import com.devtee.appman.common.viewModel
import com.devtee.appman.databinding.ActivityImageBinding
import com.devtee.appman.feature.image.di.ImageComponent

class ImageBinder(activity: AppCompatActivity,
                  binding: ActivityImageBinding,
                  component: ImageComponent): Binder {

    private val viewModel = activity.viewModel { component.getImageViewModel() }
    private val view = ImageListViewImpl(activity, binding)

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.data.observe(owner, Observer { view.setItems(it) })
    }
}