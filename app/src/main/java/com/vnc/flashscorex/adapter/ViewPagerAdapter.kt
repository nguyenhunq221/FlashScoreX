package com.vnc.flashscorex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vnc.flashscorex.ui.main.match.MatchFragment
import com.vnc.flashscorex.ui.main.standing.StandingFragment
import com.vnc.flashscorex.ui.main.topassist.TopAssistFragment
import com.vnc.flashscorex.ui.main.topscore.TopScoreFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity ): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MatchFragment()
            1 -> return StandingFragment()
            2 -> return TopScoreFragment()
            3 -> return TopAssistFragment()

            else -> return StandingFragment()
        }
    }
}