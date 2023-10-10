package com.vnc.flashscorex.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentStatePagerAdapter
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

        setUpView()
    }

    private fun setUpView() {
        with(binding) {
            val intent = intent
            var title: String? = intent.getStringExtra(Constants.KEY.PREMIER_LEAGUE)
            topAppBar.title = title
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}