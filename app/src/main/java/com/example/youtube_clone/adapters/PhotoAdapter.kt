package com.example.youtube_clone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_clone.databinding.ItemMainBinding
import com.example.youtube_clone.models2.Item
import com.squareup.picasso.Picasso

class PhotoAdapter(val onItemClickListener: OnItemClickListener) : PagingDataAdapter<Item, PhotoAdapter.Vh>(MyDiffutil()) {

    inner class Vh(var photoItemBinding: ItemMainBinding) : RecyclerView.ViewHolder(photoItemBinding.root) {

        fun onBind(hit: Item?){
            photoItemBinding.apply {
                Picasso.get().load(hit!!.snippet.thumbnails.high.url).into(image)
                root.setOnClickListener {
                    onItemClickListener.onItemClick(hit.id.videoId)
                }
            }
        }

    }

    class MyDiffutil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    interface OnItemClickListener {
        fun onItemClick(videoId: String)
    }


}