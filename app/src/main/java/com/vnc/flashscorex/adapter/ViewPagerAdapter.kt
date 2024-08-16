package com.vnc.flashscorex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vnc.flashscorex.ui.leagueInfo.match.MatchFragment
import com.vnc.flashscorex.ui.leagueInfo.standing.StandingFragment
import com.vnc.flashscorex.ui.leagueInfo.topassist.TopAssistFragment
import com.vnc.flashscorex.ui.leagueInfo.topscore.TopScoreFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, var idLeague:Int ): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MatchFragment(idLeague)
            1 -> return StandingFragment(idLeague)
            2 -> return TopScoreFragment(idLeague)
            3 -> return TopAssistFragment(idLeague)

            else -> return StandingFragment(idLeague)
        }
    }
}