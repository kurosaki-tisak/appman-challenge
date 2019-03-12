package com.devtee.appman.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devtee.appman.R
import com.devtee.appman.databinding.ItemMainListBinding

class MainListAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<MainItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false)
        return MainItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemViewHolder).bind(items[position])
    }

    inner class MainItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemMainListBinding = DataBindingUtil.bind(itemView)!!

        fun bind(item: MainItem) {
            binding.item = item
            binding.listener = View.OnClickListener { viewModel.onItemClickEvent.invoke(item) }
        }
    }
}