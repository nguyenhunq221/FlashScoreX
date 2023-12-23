package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnc.flashscorex.databinding.ItemParentStandingBinding
import com.vnc.flashscorex.model.standing.StandingDetail

class StandingParentAdapter(var mList: List<List<StandingDetail>>, var context: Context) : RecyclerView.Adapter<StandingParentAdapter.StandingParentViewHolder>() {

    private lateinit var adapter:StandingAdapter
    class StandingParentViewHolder(val binding: ItemParentStandingBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingParentViewHolder {
        val binding:ItemParentStandingBinding = ItemParentStandingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StandingParentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: StandingParentViewHolder, position: Int) {
        val listStanding = mList[position]
        adapter = StandingAdapter(listStanding,context)
        holder.binding.rcvParentStanding.adapter = adapter
        holder.binding.nameGroup.text = listStanding[0].group
    }
}