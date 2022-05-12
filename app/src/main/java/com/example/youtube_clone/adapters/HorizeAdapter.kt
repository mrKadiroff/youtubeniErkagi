package com.example.youtube_clone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_clone.databinding.ItemCardBinding
import com.squareup.picasso.Picasso

//class HorizeAdapter (var list: List<Data>) : RecyclerView.Adapter<HorizeAdapter.Vh>() {
//
//    inner class Vh(var itemMainBinding: ItemCardBinding) :
//        RecyclerView.ViewHolder(itemMainBinding.root){
//
//        fun onBind(data: Data) {
//            Picasso.get().load(data.avatar)
//                .into(itemMainBinding.rasm)
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
//        return Vh(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
//    }
//
//    override fun onBindViewHolder(holder: Vh, position: Int) {
//        holder.onBind(list[position])
//    }
//
//    override fun getItemCount(): Int = list.size
//
//
//}