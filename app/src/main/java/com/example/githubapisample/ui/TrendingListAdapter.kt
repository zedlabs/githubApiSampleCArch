package com.example.githubapisample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.RepositoryItem
import com.example.githubapisample.R

class TrendingListAdapter : ListAdapter<RepositoryItem, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.trending_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        (holder as ItemViewHolder).bind(currentItem)

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RepositoryItem) {
            val tv = itemView.findViewById<TextView>(R.id.textView_repo_name)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView_avatar)

            tv.text = item.repo
            Glide.with(itemView.context)
                .load(item.avatars?.get(0))
                .into(imageView)
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<RepositoryItem>() {

    override fun areItemsTheSame(oldItem: RepositoryItem, newItem: RepositoryItem): Boolean =
        oldItem.repo == newItem.repo

    override fun areContentsTheSame(
        oldItem: RepositoryItem,
        newItem: RepositoryItem
    ): Boolean =
        oldItem == newItem
}