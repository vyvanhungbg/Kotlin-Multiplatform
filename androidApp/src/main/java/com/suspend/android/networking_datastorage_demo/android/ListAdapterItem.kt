package com.suspend.android.networking_datastorage_demo.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.suspend.android.networking_datastorage_demo.android.databinding.ItemTvShowBinding
import com.suspend.android.networking_datastorage_demo.model.TVShow

class ListAdapterItem(private val action: (TVShow) -> Unit) :
    ListAdapter<TVShow, ListAdapterItem.ViewHolder>(ListAdapterItem.diffUtil) {


    inner class ViewHolder(val binding: ItemTvShowBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: TVShow) {
            binding.apply {
                textName.text = itemData.name
                textStatus.text = itemData.status
                textStartDate.text = itemData.startDate
                textNetwork.text = itemData.network
                imageTvShow.loadImage(itemData.thumbnail)
                root.setOnClickListener {
                    action(itemData)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TVShow>() {
            override fun areItemsTheSame(oldItem: TVShow, newItem: TVShow) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TVShow, newItem: TVShow) =
                oldItem == newItem
        }
    }
}