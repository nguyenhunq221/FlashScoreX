package com.vnc.flashscorex.ui.leagueInfo

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.ViewPagerAdapter
import com.vnc.flashscorex.base.BaseActivity
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.ActivityLeagueBinding

class LeagueActivity : BaseActivity() {
    private lateinit var binding: ActivityLeagueBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        window.statusBarColor = ContextCompat.getColor(this, R.color.back_ground_main)

        val intent = intent
        val title: String? = intent.getStringExtra(Constants.KEY.LEAGUE_TITLE)
        binding.topAppBar.title = title

        val idLeague:Int = intent.getIntExtra(Constants.KEY.LEAGUE_ID,0)

        val myViewpager = ViewPagerAdapter(this,idLeague)
        binding.viewPager.adapter = myViewpager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.match)
                1 -> tab.text = getString(R.string.standing)
                2 -> tab.text = getString(R.string.top_score)
                3 -> tab.text = getString(R.string.top_assist)
            }
        }.attach()
        binding.viewPager.offscreenPageLimit = 2

        setUpView()
    }

    private fun setUpView() {
        with(binding) {
            topAppBar.setNavigationOnClickListener{
                finish()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}