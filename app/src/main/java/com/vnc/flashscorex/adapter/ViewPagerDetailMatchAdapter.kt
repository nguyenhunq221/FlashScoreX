package com.vnc.flashscorex.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.ui.detailMatch.statistic.MatchStatisticFragment
import com.vnc.flashscorex.ui.detailMatch.matchEvent.MatchEventFragment
import com.vnc.flashscorex.ui.detailMatch.lineUp.MatchLineUpFragment
import com.vnc.flashscorex.ui.detailMatch.matchPlayerStatistic.PlayerStatisticFragment


class ViewPagerDetailMatchAdapter(fragmentActivity: FragmentActivity ): FragmentStateAdapter(fragmentActivity) {

    private var idFixture :Int? = null
    private lateinit var matchEventFragment: MatchEventFragment
    private lateinit var matchLineUpFragment : MatchLineUpFragment
    private lateinit var playerStatisticFragment : PlayerStatisticFragment

    fun setDataStatistic (idFixture: Int){
        this.idFixture = idFixture
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val matchStatisticFragment = MatchStatisticFragment()
                val bundle = Bundle()
                idFixture?.let { bundle.putInt(Constants.PUTDATA.ID_FIXTURE, it) }
                matchStatisticFragment.arguments = bundle
                return matchStatisticFragment
            }
            1 -> return MatchEventFragment()
            2 -> return MatchLineUpFragment()
            3 -> return PlayerStatisticFragment()

            else -> return MatchStatisticFragment()
        }
    }
}