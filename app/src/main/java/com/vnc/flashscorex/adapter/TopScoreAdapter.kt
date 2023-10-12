package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnc.flashscorex.databinding.ItemPlayerBinding
import com.vnc.flashscorex.model.topScore.Player
import com.vnc.flashscorex.model.topScore.ResponseDetail

class TopScoreAdapter(var mList: List<ResponseDetail>, var context: Context) : RecyclerView.Adapter<TopScoreAdapter.TopScoreViewHolder>() {
    class TopScoreViewHolder( var binding:ItemPlayerBinding) :RecyclerView.ViewHolder(binding.root){}
    private var listener:ItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScoreViewHolder {
        val binding: ItemPlayerBinding =
            ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  TopScoreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: TopScoreViewHolder, position: Int) {
        val responseDetail :ResponseDetail = mList[position]
        holder.binding.playerName.text = responseDetail.player.name
        holder.binding.clubName.text = responseDetail.statistics[0].team.name
        holder.binding.assist.text = responseDetail.statistics[0].goals.assists.toString()
        holder.binding.goals.text = responseDetail.statistics[0].goals.total.toString()

        val urlImage = responseDetail.player.photo
        Glide.with(context)
            .load(urlImage)
            .centerCrop()
            .into(holder.binding.imagePlayer)

        val urlImageClub = responseDetail.statistics[0].team.logo
        Glide.with(context)
            .load(urlImageClub)
            .centerCrop()
            .into(holder.binding.imgLogoClub)
        holder.binding.cardView.setOnClickListener{
            listener?.onClickLikePlayer(mList[position].player)
        }
    }

    interface ItemClickListener{
        fun onClickLikePlayer(player: Player)
    }

    fun setClickListener(itemClickListener: ItemClickListener){
        this.listener = itemClickListener
    }

}