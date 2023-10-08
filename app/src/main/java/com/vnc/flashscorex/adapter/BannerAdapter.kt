package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.smarteist.autoimageslider.SliderViewAdapter
import com.vnc.flashscorex.databinding.ItemBannerBinding

class BannerAdapter(var context:Context,var images:List<Int>) : SliderViewAdapter<BannerAdapter.SliderViewHolder>() {
    class SliderViewHolder(val binding:ItemBannerBinding) : ViewHolder(binding.root) {
    }

    override fun getCount(): Int {
       return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val binding:ItemBannerBinding = ItemBannerBinding.inflate(LayoutInflater.from(parent!!.context),parent,false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        viewHolder!!.binding.imageBanner.setBackgroundResource(images[position])
    }
}