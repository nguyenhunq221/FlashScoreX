package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnc.flashscorex.databinding.ItemPlayerBinding
import com.vnc.flashscorex.model.topScore.Player
import com.vnc.flashscorex.model.topScore.ResponseDetail

class TopAssistAdapter(var mList: List<ResponseDetail>, var context: Context) :
    RecyclerView.Adapter<TopAssistAdapter.TopAssistViewHolder>() {
    class TopAssistViewHolder( var binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {}

    private var listener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAssistViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopAssistViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: TopAssistViewHolder, position: Int) {
       val responseDetail :ResponseDetail = mList[position]
        holder.binding.playerName.text = responseDetail.player.name
        holder.binding.clubName.text = responseDetail.statistics[0].team.name
        holder.binding.assist.text = responseDetail.statistics[0].goals.total.toString()
        holder.binding.goals.text = responseDetail.statistics[0].goals.assists.toString()

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

        holder.itemView.setOnClickListener{
            listener?.onClickDetailPlayer(mList[position])
        }
    }

    interface ItemClickListener {
        fun onClickLikePlayer(player: Player)
        fun onClickDetailPlayer( responseDetail: ResponseDetail )
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        this.listener = itemClickListener
    }
}