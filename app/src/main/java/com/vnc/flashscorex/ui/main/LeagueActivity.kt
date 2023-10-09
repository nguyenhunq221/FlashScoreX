package com.vnc.flashscorex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vnc.flashscorex.R
import com.vnc.flashscorex.base.BaseActivity
import com.vnc.flashscorex.databinding.ActivityLeagueBinding

class LeagueActivity : BaseActivity<ActivityLeagueBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }
    override fun getDataBinding(): ActivityLeagueBinding {
        return ActivityLeagueBinding.inflate(layoutInflater)
    }
}