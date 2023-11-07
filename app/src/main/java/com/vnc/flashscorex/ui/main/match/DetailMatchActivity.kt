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
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.ActivityDetailMatchBinding
import com.vnc.flashscorex.model.statistic.ResponseDetail
import com.vnc.flashscorex.model.statistic.Statistic

class DetailMatchActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailMatchBinding
    private lateinit var viewModel:DetailMatchViewModel
    private lateinit var adapter:DetailMatchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailMatchViewModel::class.java]
        binding = ActivityDetailMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        setObserve()
        val intent = intent
        var idFixture = intent.getIntExtra(Constants.KEY.KEY_MATCH,0)
        Log.e("hung", "idFixture: "+ idFixture )
        viewModel.getStatistic(idFixture)
    }

    private fun setObserve(){
        viewModel.getListStatistic().observe(this){
            getListStatistic(it[0].statistics,it[1].statistics)
            loadLogo(it[0].team.logo,binding.logoTeamA)
            loadLogo(it[1].team.logo,binding.logoTeamB)
        }

        viewModel.getListGoal().observe(this){

        }
    }

    private fun getListStatistic(mListTeamA:List<Statistic>,mListTeamB:List<Statistic>){
        adapter = DetailMatchAdapter(mListTeamA,mListTeamB,this)
        binding.rcvStatistic.adapter = adapter
    }

    private fun loadLogo(url:String,view: ImageView){
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(view)
    }
}