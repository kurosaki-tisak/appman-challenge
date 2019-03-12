package com.devtee.appman.feature.image

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devtee.appman.R
import com.devtee.appman.databinding.ItemImageListBinding

class ImageListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Bitmap> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_list, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).bind(items[position])
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemImageListBinding = DataBindingUtil.bind(itemView)!!

        fun bind(item: Bitmap) {
            Glide.with(itemView.context)
                    .load(item)
                    .into(binding.imageView)
        }
    }

}