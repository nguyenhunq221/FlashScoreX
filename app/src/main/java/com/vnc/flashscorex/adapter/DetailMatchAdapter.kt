package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.RecyclerView
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ItemStatisticBinding
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
        return minOf(mListTeamA.size, mListTeamB.size)
    }

    override fun onBindViewHolder(holder: DetailMatchViewHolder, position: Int) {
        val statisticTeamA = mListTeamA[position]
        val statisticTeamB = mListTeamB[position]
        if (statisticTeamA.type == context.getString(R.string.shot_on_goal_en)){
            holder.binding.statisticName.text = context.getString(R.string.shot_on_goal)
        }
        if (statisticTeamA.type == context.getString(R.string.shot_off_goal_en)){
            holder.binding.statisticName.text = context.getString(R.string.shot_off_goal)
        }
        if (statisticTeamA.type == context.getString(R.string.total_shoot_en)){
            holder.binding.statisticName.text = context.getString(R.string.total_shoot)
        }
        if (statisticTeamA.type == context.getString(R.string.blocked_shoot_en)){
            holder.binding.statisticName.text = context.getString(R.string.blocked_shoot)
        }
        if (statisticTeamA.type == context.getString(R.string.shoot_inside_box_en)){
            holder.binding.statisticName.text = context.getString(R.string.shoot_inside_box)
        }
        if (statisticTeamA.type == context.getString(R.string.shoot_outside_box_en)){
            holder.binding.statisticName.text = context.getString(R.string.shoot_outside_box)
        }
        if (statisticTeamA.type == context.getString(R.string.fouls_en)){
            holder.binding.statisticName.text = context.getString(R.string.fouls)
        }
        if (statisticTeamA.type == context.getString(R.string.corner_kick_en)){
            holder.binding.statisticName.text = context.getString(R.string.corner_kick)
        }
        if (statisticTeamA.type == context.getString(R.string.off_side_en)){
            holder.binding.statisticName.text = context.getString(R.string.off_side)
        }
        if (statisticTeamA.type == context.getString(R.string.ball_possesstion_en)){
            holder.binding.statisticName.text = context.getString(R.string.ball_possesstion)
        }
        if (statisticTeamA.type == context.getString(R.string.yellow_card_en)){
            holder.binding.statisticName.text = context.getString(R.string.yellow_card)
        }
        if (statisticTeamA.type == context.getString(R.string.red_card_en)){
            holder.binding.statisticName.text = context.getString(R.string.red_card)
        }
        if (statisticTeamA.type == context.getString(R.string.goal_keeper_save_en)){
            holder.binding.statisticName.text = context.getString(R.string.goal_keeper_save)
        }
        if (statisticTeamA.type == context.getString(R.string.total_pass_en)){
            holder.binding.statisticName.text = context.getString(R.string.total_pass)
        }
        if (statisticTeamA.type == context.getString(R.string.pass_accurate_en)){
            holder.binding.statisticName.text = context.getString(R.string.pass_accurate)
        }
        if (statisticTeamA.type == context.getString(R.string.pass_percent_en)){
            holder.binding.statisticName.text = context.getString(R.string.pass_percent)
        }
        if (statisticTeamA.type == context.getString(R.string.expect_goal_en)){
            holder.binding.statisticName.text = context.getString(R.string.expect_goal)
        }


        //set max for progress bar
        if (statisticTeamA.value != null && statisticTeamB.value!= null && statisticTeamA.value.isDigitsOnly() && statisticTeamB.value.isDigitsOnly() ){
            if (statisticTeamA.value.toInt() > statisticTeamB.value.toInt()){
                holder.binding.seekBarTeamA.max = statisticTeamA.value.toInt() * 2
                holder.binding.seekBarTeamB.max = statisticTeamA.value.toInt() * 2

                holder.binding.seekBarTeamA.progress = statisticTeamA.value.toInt()
                holder.binding.seekBarTeamB.progress = statisticTeamB.value.toInt()
                holder.binding.numberTeamA.text = statisticTeamA.value
                holder.binding.numberTeamB.text = statisticTeamB.value
            }else if( statisticTeamA.value.toInt() < statisticTeamB.value.toInt()){
                holder.binding.seekBarTeamA.max = statisticTeamB.value.toInt() * 2
                holder.binding.seekBarTeamB.max = statisticTeamB.value.toInt() * 2

                holder.binding.seekBarTeamA.progress = statisticTeamA.value.toInt()
                holder.binding.seekBarTeamB.progress = statisticTeamB.value.toInt()
                holder.binding.numberTeamA.text = statisticTeamA.value
                holder.binding.numberTeamB.text = statisticTeamB.value
            }
            else if( statisticTeamA.value.toInt() == statisticTeamB.value.toInt()){
                holder.binding.seekBarTeamA.max = statisticTeamB.value.toInt() * 2
                holder.binding.seekBarTeamB.max = statisticTeamB.value.toInt() * 2

                holder.binding.seekBarTeamA.progress = statisticTeamA.value.toInt()
                holder.binding.seekBarTeamB.progress = statisticTeamB.value.toInt()
                holder.binding.numberTeamA.text = statisticTeamA.value
                holder.binding.numberTeamB.text = statisticTeamB.value
            }
        }else if (statisticTeamA.value == null && statisticTeamB.value == null){
            holder.binding.seekBarTeamA.max = 5
            holder.binding.seekBarTeamB.max = 5
            holder.binding.numberTeamA.text = "0"
            holder.binding.numberTeamB.text = "0"
            holder.binding.seekBarTeamA.progress = 0
            holder.binding.seekBarTeamB.progress = 0
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
        else if (statisticTeamA.value != null && statisticTeamA.value.contains(".") && statisticTeamB.value != null && statisticTeamB.value.contains(".")){
            holder.binding.numberTeamA.text = statisticTeamA.value
            holder.binding.seekBarTeamA.max = 10

            holder.binding.numberTeamB.text = statisticTeamB.value
            holder.binding.seekBarTeamB.max = 10

            if (statisticTeamA.value.toDouble() < 1.0){
                holder.binding.seekBarTeamA.progress = 1
            }else if (statisticTeamA.value.toDouble() > 1.0)  {
                val expectedTeamA = statisticTeamA.value.toDouble()
                holder.binding.seekBarTeamA.progress = expectedTeamA.roundToInt()
            }

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