package com.vnc.flashscorex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ItemMatchBinding
import com.vnc.flashscorex.model.fixture.ResponseDetail

class MatchAdapter(var mList: List<ResponseDetail>, var context: Context) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    private var listener:ItemClickListener? = null
    class MatchViewHolder(val binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding: ItemMatchBinding =
            ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val responseDetail:ResponseDetail = mList[position]

        holder.binding.statusMatch.text = responseDetail.fixture.status.trangThai
        if (responseDetail.fixture.status.trangThai == "FT") {
            holder.binding.awayGoal.visibility = View.VISIBLE
            holder.binding.homeGoal.visibility = View.VISIBLE
        } else {
            holder.binding.awayGoal.visibility = View.GONE
            holder.binding.homeGoal.visibility = View.GONE
        }
        val dateTime =  responseDetail.fixture.date
        val date = dateTime.take(10)
        val time = dateTime.takeLast(14)
        val timeStart = time.take(8)

        holder.binding.date.text = "$timeStart - $date"

        val roundMatch: String = responseDetail.league.round
        val numberRound = roundMatch.replace("[^0-9]".toRegex(), "")
        holder.binding.round.text = context.getString(R.string.round,numberRound)
        holder.binding.homeName.text = responseDetail.teams.home.name
        holder.binding.awayName.text = responseDetail.teams.away.name
        holder.binding.homeGoal.text = responseDetail.goals.homeGoal.toString()
        holder.binding.awayGoal.text = responseDetail.goals.awayGoal.toString()

        val logoHome = responseDetail.teams.home.logo
        Glide.with(context)
            .load(logoHome)
            .centerCrop()
            .into(holder.binding.logoHome)

        val logoAway = responseDetail.teams.away.logo
        Glide.with(context)
            .load(logoAway)
            .centerCrop()
            .into(holder.binding.logoAway)

        holder.binding.cardView.setOnClickListener{
            if (mList[position].fixture.status.trangThai == "FT"){
                listener?.onClickMatch(mList[position])
            }else{
                Toast.makeText(context, context.getString(R.string.not_have_data_match), Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface ItemClickListener{
        fun onClickMatch(responseDetail: ResponseDetail)
    }

    fun setClickListener(itemClickListener: ItemClickListener){
        this.listener = itemClickListener
    }
}