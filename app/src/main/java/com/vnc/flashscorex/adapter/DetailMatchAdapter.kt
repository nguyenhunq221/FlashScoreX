package com.vnc.flashscorex.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.RecyclerView
import com.vnc.flashscorex.databinding.ItemStatisticBinding
import com.vnc.flashscorex.model.statistic.ResponseDetail
import com.vnc.flashscorex.model.statistic.Statistic
import kotlin.math.roundToInt

class DetailMatchAdapter(var mListTeamA:List<Statistic>,var mListTeamB:List<Statistic>,var context: Context) : RecyclerView.Adapter<DetailMatchAdapter.DetailMatchViewHolder>() {
    class DetailMatchViewHolder(var binding:ItemStatisticBinding) :RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailMatchViewHolder {
       val binding = ItemStatisticBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DetailMatchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.e("hung", minOf(mListTeamA.size, mListTeamB.size).toString() )
        return minOf(mListTeamA.size, mListTeamB.size)
    }

    override fun onBindViewHolder(holder: DetailMatchViewHolder, position: Int) {
        val statisticTeamA = mListTeamA[position]
        val statisticTeamB = mListTeamB[position]
        holder.binding.statisticName.text = statisticTeamA.type
        if (statisticTeamA.value != null && statisticTeamB.value!= null && statisticTeamA.value.isDigitsOnly() && statisticTeamB.value.isDigitsOnly() ){
            if (statisticTeamA.value.toInt() > statisticTeamB.value.toInt()){
                holder.binding.seekBarTeamA.max = statisticTeamA.value.toInt() * 2
                holder.binding.seekBarTeamB.max = statisticTeamA.value.toInt() * 2
            }else if( statisticTeamA.value.toInt() < statisticTeamB.value.toInt()){
                holder.binding.seekBarTeamA.max = statisticTeamB.value.toInt() * 2
                holder.binding.seekBarTeamB.max = statisticTeamB.value.toInt() * 2
            }
            else if( statisticTeamA.value.toInt() == statisticTeamB.value.toInt()){
                holder.binding.seekBarTeamA.max = statisticTeamB.value.toInt() * 2
                holder.binding.seekBarTeamB.max = statisticTeamB.value.toInt() * 2
            }
        }else if (statisticTeamA.value == null && statisticTeamB.value == null){
            holder.binding.seekBarTeamA.max = 0
            holder.binding.seekBarTeamB.max = 0
            holder.binding.numberTeamA.text = "0"
            holder.binding.numberTeamB.text = "0"
            holder.binding.seekBarTeamA.progress = 0
            holder.binding.seekBarTeamB.progress = 0
        }
        else if (statisticTeamA.value != null && statisticTeamB.value!= null && statisticTeamA.value.isDigitsOnly() && statisticTeamB.value.isDigitsOnly()){
            holder.binding.seekBarTeamA.progress = statisticTeamA.value.toInt()
            holder.binding.seekBarTeamB.progress = statisticTeamB.value.toInt()
            holder.binding.numberTeamA.text = statisticTeamA.value
            holder.binding.numberTeamB.text = statisticTeamB.value
        }
        else if (statisticTeamA.value == null && statisticTeamB.value != null && statisticTeamB.value.isDigitsOnly() ){
            holder.binding.numberTeamA.text = "0"
            holder.binding.seekBarTeamA.progress = 0
            holder.binding.seekBarTeamB.max = statisticTeamB.value.toInt() * 5
            holder.binding.seekBarTeamB.progress = statisticTeamB.value.toInt()
            holder.binding.numberTeamB.text = statisticTeamB.value
        }
        else if (statisticTeamB.value == null && statisticTeamA.value != null && statisticTeamA.value.isDigitsOnly() ){
            holder.binding.numberTeamB.text = "0"
            holder.binding.seekBarTeamB.progress = 0
            holder.binding.seekBarTeamA.max = statisticTeamA.value.toInt() * 5
            holder.binding.seekBarTeamA.progress = statisticTeamA.value.toInt()
            holder.binding.numberTeamA.text = statisticTeamA.value
        }
        else if (statisticTeamA.value != null && statisticTeamA.value.contains(".")){
            holder.binding.numberTeamA.text = statisticTeamA.value
            holder.binding.seekBarTeamA.max = 10
            if (statisticTeamA.value.toDouble() < 1.0){
                holder.binding.seekBarTeamA.progress = 1
            }else if (statisticTeamA.value.toDouble() > 1.0)  {
                val expectedTeamA = statisticTeamA.value.toDouble()
                holder.binding.seekBarTeamA.progress = expectedTeamA.roundToInt()
            }
        }
        else if (statisticTeamB.value != null && statisticTeamB.value.contains(".")){
            holder.binding.numberTeamB.text = statisticTeamB.value
            holder.binding.seekBarTeamB.max = 10

            if (statisticTeamB.value.toDouble() < 1.0){
                holder.binding.seekBarTeamB.progress = 1
            }else if (statisticTeamB.value.toDouble() > 1.0){
                val expectedTeamB = statisticTeamB.value.toDouble()
                holder.binding.seekBarTeamB.progress = expectedTeamB.roundToInt()
            }
        }
        else if(statisticTeamA.value != null && statisticTeamB.value!= null && statisticTeamA.value.contains("%") && statisticTeamB.value.contains("%")){
            val percentValueA = (statisticTeamA.value).split("%")[0]
            val percentValueB = (statisticTeamB.value).split("%")[0]
            holder.binding.seekBarTeamA.progress = percentValueA.toInt()
            holder.binding.seekBarTeamB.progress = percentValueB.toInt()
            holder.binding.numberTeamA.text = statisticTeamA.value
            holder.binding.numberTeamB.text = statisticTeamB.value
            holder.binding.seekBarTeamA.max = 100
            holder.binding.seekBarTeamB.max = 100
        }

    }
}