package com.vnc.flashscorex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vnc.flashscorex.ui.main.MatchFragment
import com.vnc.flashscorex.ui.main.StandingFragment
import com.vnc.flashscorex.ui.main.TopAssistFragment
import com.vnc.flashscorex.ui.main.TopScoreFragment

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