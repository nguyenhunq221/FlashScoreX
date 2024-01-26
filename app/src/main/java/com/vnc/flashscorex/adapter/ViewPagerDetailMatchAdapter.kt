package com.vnc.flashscorex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vnc.flashscorex.ui.detailMatch.statistic.MatchStatisticFragment
import com.vnc.flashscorex.ui.main.match.MatchFragment
import com.vnc.flashscorex.ui.main.standing.StandingFragment
import com.vnc.flashscorex.ui.main.topassist.TopAssistFragment
import com.vnc.flashscorex.ui.main.topscore.TopScoreFragment

class ViewPagerDetailMatchAdapter(fragmentActivity: FragmentActivity ): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MatchStatisticFragment()
            1 -> return MatchStatisticFragment()
            2 -> return MatchStatisticFragment()
            3 -> return MatchStatisticFragment()

            else -> return MatchStatisticFragment()
        }
    }
}