package com.vnc.flashscorex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vnc.flashscorex.ui.player.MatchEventFragment
import com.vnc.flashscorex.ui.player.MatchLineUpFragment
import com.vnc.flashscorex.ui.detailMatch.statistic.MatchStatisticFragment
import com.vnc.flashscorex.ui.player.PlayerStatisticFragment

class DetailMatchPagerAdapter (fragmentActivity: FragmentActivity ): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MatchStatisticFragment()
            1 -> return MatchEventFragment()
            2 -> return MatchLineUpFragment()
            3 -> return PlayerStatisticFragment()

            else -> return MatchStatisticFragment()
        }
    }
}