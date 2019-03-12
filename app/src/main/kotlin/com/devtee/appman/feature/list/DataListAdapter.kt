package com.devtee.appman.feature.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devtee.appman.R
import com.devtee.appman.databinding.ItemDataListBinding

class DataListAdapter(private val viewModel: DataListViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<DataListItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DataItemViewHolder).bind(items[position])
    }

    inner class DataItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemDataListBinding = DataBindingUtil.bind(itemView)!!

        fun bind(item: DataListItem) {
            binding.item = item
            binding.listener = View.OnClickListener { }
        }
    }
}