package com.example.newyork.ui.most_popular.most_popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newyork.data.models.MostPopularModel
import com.example.newyork.databinding.ItemMostPopularBinding

class MostPopularAdapter(private val clickListener: OnMostPopularItemClickListener) :
    ListAdapter<MostPopularModel, MostPopularAdapter.ViewHolder>(MostPopularDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, position, clickListener)
        }

    }

    class ViewHolder internal constructor(val binding: ItemMostPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: MostPopularModel,
            position: Int,
            clickListener: OnMostPopularItemClickListener
        ) {
            binding.model = item
            binding.position = position
            binding.clickListener = clickListener

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMostPopularBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}

class OnMostPopularItemClickListener(
    val itemClickListener: (model: MostPopularModel) -> Unit,
) {
    fun onItemClick(model: MostPopularModel) =
        itemClickListener(model)
}


class MostPopularDiffCallback : DiffUtil.ItemCallback<MostPopularModel>() {
    override fun areItemsTheSame(oldItem: MostPopularModel, newItem: MostPopularModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MostPopularModel, newItem: MostPopularModel): Boolean {
        return oldItem == newItem
    }
}