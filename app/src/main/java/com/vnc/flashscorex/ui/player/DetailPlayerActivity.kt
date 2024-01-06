package com.vnc.flashscorex.ui.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.vnc.flashscorex.R
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.ActivityDetailPlayerBinding
import com.vnc.flashscorex.model.topScore.ResponseDetail

class DetailPlayerActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        setUpView()
    }

    private fun setUpView() = with (binding){
       val detailPlayer = intent.getSerializableExtra(Constants.PUTDATA.DETAIL_PLAYER) as ResponseDetail

        birth.text = detailPlayer.player.birth.date
        namePlayer.text = detailPlayer.player.name

        if ((detailPlayer.statistics[0].games.position) == getString(R.string.player_ST_eng)){
            viTri.text = getString(R.string.player_ST)
        }
        if ((detailPlayer.statistics[0].games.position) == getString(R.string.player_CM_eng)){
            viTri.text = getString(R.string.player_CM)
        }

        if ( (detailPlayer.statistics[0].games.number) != null ){
            number.text = detailPlayer.statistics[0].games.number
        }

        nation.text = detailPlayer.player.nationality

        if (detailPlayer.statistics[0].games.captain){
            captain.visibility = View.VISIBLE
        }

        if((detailPlayer.statistics[0].games.rating) > 7.0){
            star.visibility = View.VISIBLE
            rating.text = detailPlayer.statistics[0].games.rating.toString()
        }else if ((detailPlayer.statistics[0].games.rating) == null){
            rating.text = " "
        }

        if(detailPlayer.player.injured){
            injury.text = getString(R.string.injury)
        }else{
            injury.text = getString(R.string.not_injury)
        }

        Glide.with(this@DetailPlayerActivity)
            .load(detailPlayer.statistics[0].team.logo)
            .centerCrop()
            .into(imageLogo)

        Glide.with(this@DetailPlayerActivity)
            .load(detailPlayer.player.photo)
            .centerCrop()
            .into(imageDetailPlayer)

    }
}