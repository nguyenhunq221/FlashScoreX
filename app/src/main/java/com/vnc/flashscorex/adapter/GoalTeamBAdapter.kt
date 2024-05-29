package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vnc.flashscorex.databinding.ItemGoalBinding
import com.vnc.flashscorex.model.event.GoalModel

class GoalTeamBAdapter(var context: Context, var mList: List<GoalModel>) :
    RecyclerView.Adapter<GoalTeamBAdapter.GoalViewHolder>() {
    class GoalViewHolder(val binding: ItemGoalBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val binding: ItemGoalBinding =
            ItemGoalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GoalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if (mList.isNotEmpty()) {
            return mList.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal: GoalModel = mList[position]
        if (goal.time.extra != null){
            holder.binding.txtGoal.text = goal.player.name + " - " + goal.time.minuteGoal.toString() + "+" +goal.time.extra.toString()
        }else{
            holder.binding.txtGoal.text = goal.player.name + " - " + goal.time.minuteGoal.toString()
        }
    }
}