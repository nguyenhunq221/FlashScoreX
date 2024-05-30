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


class ViewPagerDetailMatchAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private var idFixture: Int? = null

    fun setDataStatistic(idFixture: Int) {
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

            1 -> {
                val matchEventFragment = MatchEventFragment()
                val bundle = Bundle()
                idFixture?.let { bundle.putInt(Constants.PUTDATA.ID_FIXTURE, it) }
                matchEventFragment.arguments = bundle
                return MatchEventFragment()
            }

            2 -> {
                val matchLineUpFragment = MatchLineUpFragment()
                val bundle = Bundle()
                idFixture?.let { bundle.putInt(Constants.PUTDATA.ID_FIXTURE, it) }
                matchLineUpFragment.arguments = bundle
                return MatchLineUpFragment()
            }

            3 -> return PlayerStatisticFragment()

            else -> return MatchStatisticFragment()
        }
    }
}