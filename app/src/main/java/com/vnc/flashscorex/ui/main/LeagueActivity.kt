package com.vnc.flashscorex.ui.main

import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayoutMediator
import com.vnc.flashscorex.R
import com.vnc.flashscorex.adapter.ViewPagerAdapter
import com.vnc.flashscorex.base.BaseActivity
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.ActivityLeagueBinding
import com.vnc.flashscorex.ui.main.match.MatchFragment
import com.vnc.flashscorex.ui.main.standing.StandingFragment
import com.vnc.flashscorex.ui.main.topassist.TopAssistFragment
import com.vnc.flashscorex.ui.main.topscore.TopScoreFragment

class LeagueActivity : BaseActivity() {
    private lateinit var binding: ActivityLeagueBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val myViewpager = ViewPagerAdapter(this)
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
            val intent = intent
            val title: String? = intent.getStringExtra(Constants.KEY.LEAGUE_TITLE)
            topAppBar.title = title

            val idLeague:Int = intent.getIntExtra(Constants.KEY.LEAGUE_ID,0)
            Log.e("hung", "id: "+ idLeague )
            val bundle = Bundle()
            bundle.putInt(Constants.KEY.LEAGUE_ID, idLeague)

            val matchFragment = MatchFragment()
            matchFragment.arguments = bundle
            val topScoreFragment = TopScoreFragment()
            topScoreFragment.arguments = bundle
            val topAssistFragment = TopAssistFragment()
            topAssistFragment.arguments = bundle
            val standingFragment = StandingFragment()
            standingFragment.arguments = bundle

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.viewPager, matchFragment)
            fragmentTransaction.add(R.id.viewPager, topScoreFragment)
            fragmentTransaction.add(R.id.viewPager, topAssistFragment)
            fragmentTransaction.add(R.id.viewPager, standingFragment)
            fragmentTransaction.commit()

            topAppBar.setNavigationOnClickListener{
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}