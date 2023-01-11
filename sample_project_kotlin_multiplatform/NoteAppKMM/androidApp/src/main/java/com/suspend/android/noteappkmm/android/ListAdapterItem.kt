package com.suspend.android.noteappkmm.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.suspend.android.noteappkmm.android.databinding.ItemBinding
import com.suspend.android.noteappkmm.domain.note.Note
import com.suspend.android.noteappkmm.domain.time.DateTimeUtil.formatNoteDate

class ListAdapterItem(private val action: (Note) -> Unit) :
    ListAdapter<Note, ListAdapterItem.ViewHolder>(ListAdapterItem.diffUtil) {


    inner class ViewHolder(val binding: ItemBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Note) {
            binding.textViewTitle.text = item.title
            binding.textViewContent.text = item.content
            binding.textViewTime.text = formatNoteDate(item.created)
            binding.cardView.setCardBackgroundColor(item.colorHex.toInt())
            binding.imageViewDelete.setOnClickListener {
                action(item)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}