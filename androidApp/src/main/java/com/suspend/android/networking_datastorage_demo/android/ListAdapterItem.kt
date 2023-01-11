package com.suspend.android.networking_datastorage_demo.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.suspend.android.networking_datastorage_demo.android.databinding.ItemBinding
import com.suspend.android.networking_datastorage_demo.model.RocketLaunch
import com.suspend.android.networking_datastorage_demo.utils.toDateForHuman

class ListAdapterItem(private val action: (RocketLaunch) -> Unit) :
    ListAdapter<RocketLaunch, ListAdapterItem.ViewHolder>(ListAdapterItem.diffUtil) {


    inner class ViewHolder(val binding: ItemBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RocketLaunch) {
            binding.textViewTitle.text = item.details
            binding.textViewContent.text = item.details
            binding.textViewTime.text = item.launchDateUTC.toDateForHuman()
            binding.imageViewDelete.setOnClickListener {
                action(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RocketLaunch>() {
            override fun areItemsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch) =
                oldItem.launchDateUTC == newItem.launchDateUTC

            override fun areContentsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch) =
                oldItem == newItem
        }
    }
}