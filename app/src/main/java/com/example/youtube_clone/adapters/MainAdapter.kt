package com.example.youtube_clone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_clone.databinding.ItemMainBinding
import com.example.youtube_clone.models2.Item
import com.squareup.picasso.Picasso

class MainAdapter(var list: List<Item>,val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<MainAdapter.Vh>() {

    inner class Vh(var itemMainBinding: ItemMainBinding) :
        RecyclerView.ViewHolder(itemMainBinding.root){

        fun onBind(item: Item) {
            item.snippet.thumbnails.medium.url
            Picasso.get().load(item!!.snippet.thumbnails.high.url).into(itemMainBinding.image)
            itemMainBinding.nameofsong.text = "${item.snippet.title}, ${item.snippet.description}"
            itemMainBinding.prosmotr.text = item.snippet.publishTime

            itemMainBinding.image.setOnClickListener {
                onItemClickListener.onItemClick(item.id.videoId)
            }

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int = list.size
    interface OnItemClickListener {
        fun onItemClick(videoId: String)
    }

}
