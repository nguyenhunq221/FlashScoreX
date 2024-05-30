package com.vnc.flashscorex.ui.detailMatch.statistic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vnc.flashscorex.adapter.DetailMatchAdapter
import com.vnc.flashscorex.adapter.GoalAdapter
import com.vnc.flashscorex.adapter.GoalTeamBAdapter
import com.vnc.flashscorex.base.BaseFragment
import com.vnc.flashscorex.constant.Constants
import com.vnc.flashscorex.databinding.FragmentMatchStatisticBinding
import com.vnc.flashscorex.model.statistic.Statistic

class MatchStatisticFragment : BaseFragment() {
    private var _binding:FragmentMatchStatisticBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MatchStatisticViewModel
    private lateinit var goalAdapter: GoalAdapter
    private lateinit var goalBAdapter: GoalTeamBAdapter
    private lateinit var adapter: DetailMatchAdapter

    companion object{
        private const val TAG = "MatchStatisticFragment"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MatchStatisticViewModel::class.java]

        val bundle = this.arguments
        bundle?.let {
            val idFixture = it.getInt(Constants.PUTDATA.ID_FIXTURE,0)
            Log.e(TAG, "idFixture: " + idFixture )
            viewModel.getStatistic(idFixture)
        }

        _binding = FragmentMatchStatisticBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun setObserver() {
        viewModel.getListStatistic().observe(this){
            if (it.isNotEmpty()){
                getListStatistic(it[0].statistics,it[1].statistics)
            }
        }
    }

    override fun initView() {
        val bundle = this.arguments
    }

    fun getStatistic(idFixture: Int){
        viewModel.getStatistic(idFixture)
    }

    private fun getListStatistic(mListTeamA:List<Statistic>, mListTeamB:List<Statistic>){
        adapter = DetailMatchAdapter(mListTeamA,mListTeamB,requireActivity())
        binding.rcvStatistic.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}