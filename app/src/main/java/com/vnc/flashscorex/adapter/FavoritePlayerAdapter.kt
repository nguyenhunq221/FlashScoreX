package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnc.flashscorex.databinding.ItemFavorPlayerBinding
import com.vnc.flashscorex.model.topScore.Player

class FavoritePlayerAdapter(var mList: List<Player>, var context: Context) :
    RecyclerView.Adapter<FavoritePlayerAdapter.FavoritePlayerViewHolder>() {
    class FavoritePlayerViewHolder(var binding: ItemFavorPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritePlayerViewHolder {
        val binding =
            ItemFavorPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritePlayerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: FavoritePlayerViewHolder, position: Int) {
        val player = mList[position]
        holder.binding.playerName.text = player.name

        val urlImage = player.photo
        Glide.with(context)
            .load(urlImage)
            .centerCrop()
            .into(holder.binding.imagePlayer)

        holder.binding.birthDay.text = player.birth.date
        holder.binding.tvNation.text = player.nationality
    }
}