package com.vnc.flashscorex.ui.main.match

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.DetailMatchAdapter
import com.vnc.flashscorex.adapter.GoalAdapter
import com.vnc.flashscorex.adapter.GoalTeamBAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.ActivityDetailMatchBinding
import com.vnc.flashscorex.model.event.GoalModel
import com.vnc.flashscorex.model.statistic.ResponseDetail
import com.vnc.flashscorex.model.statistic.Statistic

class DetailMatchActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailMatchBinding
    private lateinit var viewModel:DetailMatchViewModel
    private lateinit var adapter:DetailMatchAdapter
    private lateinit var goalAdapter:GoalAdapter
    private lateinit var goalBAdapter:GoalTeamBAdapter
    private var idTeamA:Int = 0
    private var idTeamB:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailMatchViewModel::class.java]
        binding = ActivityDetailMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        setObserve()
        viewModel.getListGoal().observe(this){
            getListGoal(it)
        }
        val intent = intent
        var idFixture = intent.getIntExtra(Constants.KEY.KEY_MATCH,0)
        viewModel.getStatistic(idFixture)
        viewModel.getGoal(idFixture)
    }

    private fun setObserve(){
        viewModel.getListStatistic().observe(this){
            getListStatistic(it[0].statistics,it[1].statistics)
            loadLogo(it[0].team.logo,binding.logoTeamA)
            loadLogo(it[1].team.logo,binding.logoTeamB)
            idTeamA = it[0].team.id
            idTeamB = it[1].team.id
        }

    }

    private fun getListStatistic(mListTeamA:List<Statistic>,mListTeamB:List<Statistic>){
        adapter = DetailMatchAdapter(mListTeamA,mListTeamB,this)
        binding.rcvStatistic.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun getListGoal(mList:List<GoalModel>){
        var listGoalTeamA:MutableList<GoalModel> = mutableListOf()
        var listGoalTeamB:MutableList<GoalModel> = mutableListOf()

        for (i in mList.indices){
            if(mList[i].team.id == idTeamA){
                listGoalTeamA.add(mList[i])
            }else if (mList[i].team.id == idTeamB){
                listGoalTeamB.add(mList[i])
            }
        }

        goalAdapter = GoalAdapter(this,listGoalTeamA)
        goalBAdapter = GoalTeamBAdapter(this,listGoalTeamB)
        binding.rcvGoal.adapter = goalAdapter
        binding.rcvGoalTeamB.adapter = goalBAdapter
    }

    private fun loadLogo(url:String,view: ImageView){
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(view)
    }
}