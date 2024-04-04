package com.vnc.flashscorex.ui.main.match

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.DetailMatchAdapter
import com.vnc.flashscorex.adapter.GoalAdapter
import com.vnc.flashscorex.adapter.GoalTeamBAdapter
import com.vnc.flashscorex.adapter.ViewPagerDetailMatchAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.ActivityDetailMatchBinding
import com.vnc.flashscorex.model.event.GoalModel

class DetailMatchActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailMatchBinding
    private lateinit var viewModel:DetailMatchViewModel
    private lateinit var adapter:DetailMatchAdapter
    private lateinit var goalAdapter:GoalAdapter
    private lateinit var goalBAdapter:GoalTeamBAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailMatchViewModel::class.java]
        binding = ActivityDetailMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_detail_match)
        setObserve()
        val intent = intent
        var idFixture = intent.getIntExtra(Constants.KEY.KEY_MATCH,0)
        viewModel.getStatistic(idFixture)
        viewModel.getGoal(idFixture)

        val myViewpager = ViewPagerDetailMatchAdapter(this)
        binding.viewPagerDetailMatch.adapter = myViewpager
        TabLayoutMediator(binding.tabLayoutDetailMatch, binding.viewPagerDetailMatch) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.title_statistic)
                1 -> tab.text = getString(R.string.line_up)
                2 -> tab.text = getString(R.string.event)
                3 -> tab.text = getString(R.string.player_statistic)
            }
        }.attach()
        binding.viewPagerDetailMatch.offscreenPageLimit = 2

        myViewpager.setDataStatistic(idFixture)
    }

    private fun getCurrentFragment() = supportFragmentManager.findFragmentByTag("f${binding.viewPagerDetailMatch.currentItem}")

    private fun setObserve(){
        viewModel.getListStatistic().observe(this){
            loadLogo(it[0].team.logo,binding.logoTeamA)
            loadLogo(it[1].team.logo,binding.logoTeamB)
            var idTeamA = it[0].team.id
            var idTeamB = it[1].team.id

            viewModel.getListGoal().observe(this){list ->
                getListGoal(list,idTeamA,idTeamB)
            }
        }

    }

    private fun getListGoal(mList:List<GoalModel>, idTeamA:Int,idTeamB:Int){
        var listGoalTeamA:MutableList<GoalModel> = mutableListOf()
        var listGoalTeamB:MutableList<GoalModel> = mutableListOf()

        for (i in mList.indices){
            if(mList[i].team.id == idTeamA){
                listGoalTeamA.add(mList[i])
            }else if (mList[i].team.id == idTeamB){
                listGoalTeamB.add(mList[i])
            }
        }

        binding.goalsTeamA.text = listGoalTeamA.size.toString()
        binding.goalsTeamB.text = listGoalTeamB.size.toString()

        goalAdapter = GoalAdapter(this,listGoalTeamA)
        goalAdapter.notifyDataSetChanged()
        goalBAdapter = GoalTeamBAdapter(this,listGoalTeamB)
        goalBAdapter.notifyDataSetChanged()
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