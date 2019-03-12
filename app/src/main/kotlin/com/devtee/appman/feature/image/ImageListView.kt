package com.devtee.appman.feature.image

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.devtee.appman.databinding.ActivityImageBinding

interface ImageListView {
    fun setItems(items: List<Bitmap>?)
}

class ImageListViewImpl(private val activity: AppCompatActivity,
                        binding: ActivityImageBinding) : ImageListView {

    private val listAdapter = ImageListAdapter()

    init {
        with(binding.recyclerViewImage) {

            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = listAdapter
        }
    }

    override fun setItems(items: List<Bitmap>?) {
        listAdapter.items = items ?: emptyList()
    }
}