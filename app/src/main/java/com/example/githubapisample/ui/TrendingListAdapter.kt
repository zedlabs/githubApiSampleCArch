package com.example.githubapisample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.RepositoryItem
import com.example.githubapisample.R


class TrendingListAdapter(private val listener: OnItemClickListener) : ListAdapter<RepositoryItem, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.trending_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        (holder as ItemViewHolder).bind(currentItem)
        ViewCompat.setTransitionName(holder.imageView, currentItem.repo)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tv: TextView = itemView.findViewById(R.id.textView_repo_name)
        val imageView: ImageView = itemView.findViewById(R.id.imageView_avatar)

        fun bind(item: RepositoryItem) {

            tv.text = item.repo
            Glide.with(itemView.context)
                .load(item.avatars?.get(0) ?: "")
                .into(imageView)

            itemView.setOnClickListener {
                listener.onItemClick(item, imageView)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: RepositoryItem, imageView: ImageView)
    }

}

class DiffCallback : DiffUtil.ItemCallback<RepositoryItem>() {

    override fun areItemsTheSame(oldItem: RepositoryItem, newItem: RepositoryItem): Boolean =
        oldItem.repo == newItem.repo

    override fun areContentsTheSame(
        oldItem: RepositoryItem,
        newItem: RepositoryItem
    ): Boolean = oldItem == newItem
}