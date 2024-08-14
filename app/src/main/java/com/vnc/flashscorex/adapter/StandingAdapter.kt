package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnc.flashscorex.databinding.ItemStandingBinding
import com.vnc.flashscorex.model.standing.StandingDetail

class StandingAdapter(var mList:List<StandingDetail>,  var context: Context) : RecyclerView.Adapter<StandingAdapter.StandingViewHolder>() {

    class StandingViewHolder( val binding: ItemStandingBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingViewHolder {
        val binding = ItemStandingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StandingViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: StandingViewHolder, position: Int) {
        val standingDetail = mList[position]
        holder.binding.teamName.text = standingDetail.team.name
        holder.binding.played.text = standingDetail.all.played.toString()
        holder.binding.win.text = standingDetail.all.win.toString()
        holder.binding.lose.text = standingDetail.all.lose.toString()
        holder.binding.draw.text = standingDetail.all.draw.toString()
        holder.binding.diff.text = standingDetail.hieuSo.toString()
        holder.binding.pts.text = standingDetail.points.toString()
        holder.binding.rank.text = standingDetail.rank.toString()

        val urlImage = standingDetail.team.logo
        Glide.with(context)
            .load(urlImage)
            .centerCrop()
            .into(holder.binding.logoTeam)
    }
}